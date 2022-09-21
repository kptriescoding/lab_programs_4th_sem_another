#include<stdio.h>
#include<stdlib.h>
#include<shadow.h>
#include<crypt.h>
#include<string.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<fcntl.h>
#include<signal.h>
#include<syslog.h>
char *p1="/tmp/fifo1",*p2="/tmp/fifo2";
int fd1,fd2;
int handle_pass(){
char user[1000],pass[1000],user_pass[1000],response[1000];
read(fd1,user_pass,sizeof(user_pass));
int i=0,j=0;
while(user_pass[i]!='$')user[j++]=user_pass[i++];
i++;
j=0;
while(user_pass[i]!='$')pass[j++]=user_pass[i++];
pass[j]='\0';
struct spwd *suser=getspnam(user);
if(suser==NULL){
strcpy(response,"Insufficient permission or invalid user\n");
write(fd2,response,sizeof(response));
return -1;
}
char* pass1=suser->sp_pwdp;
char salt[100];
for(int i=0;i<20;i++)salt[i]=pass1[i];
char* pass2=crypt(pass,salt);
if(strcmp(pass1,pass2)==0){
strcpy(response,"Correct");
write(fd2,response,sizeof(response));
return 1;
}
else {
strcpy(response,"Incorrect Password\n");
write(fd2,response,sizeof(response));
return -1;
}
}
void daemonise(){
int rv=fork();
if(rv<0)exit(-1);
else if(rv>0)exit(0);
if(setsid()<0)exit(-1);
rv=fork();
if(rv<0)exit(-1);
else if(rv>0)exit(0);
signal(SIGCHLD,SIG_IGN);
signal(SIGHUP,SIG_IGN);
umask(0);
for(int x=sysconf(_SC_OPEN_MAX);x>0;x--)close(x);
openlog("filedaemond",LOG_PID,LOG_DAEMON);
}
int main(){
daemonise();
mkfifo(p1,0666);
mkfifo(p2,0666);
fd1=open(p1,O_RDONLY);
fd2=open(p2,O_WRONLY);
while(1){
if(handle_pass()==1)break;
}
unlink(p1);
unlink(p2);
}
