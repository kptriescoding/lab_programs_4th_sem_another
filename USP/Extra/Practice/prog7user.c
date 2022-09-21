#include<stdio.h>
#include<string.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<fcntl.h>
int main(){
char *p1="/tmp/fifo1",*p2="/tmp/fifo2",*p3="../../test-file";
int fd1,fd2,fd3;
char user[1000],pass[1000],user_pass[1000],response[1000];
fd1=open(p1,O_WRONLY);
fd2=open(p2,O_RDONLY);
fd3=open(p3,O_RDWR);
while(1){
printf("Enter the username and password\n");
scanf("%s",user);
scanf("%s",pass);
int i=0,j=0;
while(user[i]!='\0')user_pass[j++]=user[i++];
user_pass[j++]='$';
i=0;
while(pass[i]!='\0')user_pass[j++]=pass[i++];
user_pass[j++]='$';
user_pass[j]='\0';
write(fd1,user_pass,sizeof(user_pass));
read(fd2,response,sizeof(response));
if(strcmp(response,"Correct")==0){
read(fd3,response,sizeof(response));
printf("%s",response);
return 0;
}
else 
printf("%s",response);
}
}
