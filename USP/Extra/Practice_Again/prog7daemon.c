#include<stdio.h>
#include<syslog.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>
#include<shadow.h>
#include<crypt.h>
#include<string.h>
#include<stdlib.h>

char *p1="/tmp/fifo1",*p2="/tmp/fifo2";
int fd1,fd2;
int login(){
char msg[100],user[100],pass[100],salt[100],cpass[100];
printf("Waiting for msg\n");
read(fd1,msg,sizeof(msg));
//printf("%s\n",msg);
int i=0,j=0;
while(msg[i]!='$')user[j++]=msg[i++];
j=0;i++;
while(msg[i]!='$')pass[j++]=msg[i++];
//printf("%s$%s\n",user,pass);
struct spwd *us=getspnam(user);
if(us==NULL){
write(fd2,"User dooesn't exist or insufficient permission\n",10000);
return -1;
}
strcpy(cpass,us->sp_pwdp);
for(int i=0;i<20;i++)salt[i]=cpass[i];
int x=strcmp(cpass,crypt(pass,salt));
if(x==0){
write(fd2,"Yes\n",1000);
return 0;
}
else{
write(fd2,"No\n",1000);
return -1;
} 
}
void daemonize(){
int pid=fork();
if(pid>0)exit(0);
chdir("/");
setsid();
umask(0);
for(int i=sysconf(_SC_OPEN_MAX);i>0;i--)
close(i);
openlog("filedaemon",LOG_PID,LOG_DAEMON);
syslog(LOG_NOTICE,"Daemon Started");
}
int main(){
daemonize();
mkfifo(p1,O_CREAT|0666);
mkfifo(p2,O_CREAT|0666);
fd1=open(p1,O_RDONLY);
fd2=open(p2,O_WRONLY);
int r=-1;
while(r==-1){
r=login();
}
close(fd1);
close(fd2);
unlink(p1);
unlink(p2);
closelog();
}
