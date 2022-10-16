#include<stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>
#include<string.h>

char *p1="/tmp/fifo1",*p2="/tmp/fifo2",p3[100],garb;
int fd1,fd2,fd3;
int check(){
char msg[100],user[100]="kptreklmsel",pass[100]="King@123",res[100];
printf("Enter username and pass\n");
scanf("%s%s",user,pass);
int i=0,j=0;
while(user[i]!='\0')msg[j++]=user[i++];
i=0;
msg[j++]='$';
while(pass[i]!='\0')msg[j++]=pass[i++];
msg[j++]='$';
write(fd1,msg,sizeof(msg));
read(fd2,res,sizeof(res));
if(strcmp(res,"Yes\n")==0){
printf("Enter path to file\n");
scanf("%c",&garb);
scanf("%[^\n]s",p3);
fd3=open(p3,O_RDWR);
if(fd3!=-1){
read(fd3,msg,sizeof(msg));
printf("%s\n",msg);
}
else printf("Invalid file\n");
}
else
printf("%s",res);
}
int main(){
fd1=open(p1,O_WRONLY);
fd2=open(p2,O_RDONLY);
fd3=open(p3,O_RDWR);
while(1){
check();
}
}
