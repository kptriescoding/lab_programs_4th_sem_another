#include <stdio.h>     
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include<stdlib.h>
#include<string.h>
struct message
{
long mtype;
char mtext[100];
};
int main()
{
    char* p1="/tmp/fifo1",*p2="/tmp/fifo2",*p3="test-file";
    int fd1=open(p1,O_WRONLY);
    int fd2=open(p2,O_RDONLY);
    int fd3=open(p3,O_RDWR);
    char username[1000],pass[1000],us_pass[1000],response[1000],file_contents[1000];
  while(1)
  {
   printf("Enter the username and password\n");
   scanf("%s",username);
   scanf("%s",pass);
   int i=0,j=0;
   while(username[j]!='\0')us_pass[i++]=username[j++];
   us_pass[i++]='$';
   j=0;
   while(pass[j]!='\0')us_pass[i++]=pass[j++];
   us_pass[i]='$';
   write(fd1,us_pass,sizeof(us_pass));
   read(fd2,response,sizeof(response));
   if(strcmp(response,"Password is Correct Access Granted")==0){
    read(fd3,file_contents,sizeof(file_contents));
    printf("Access Granted\nThe contents of the file is\n %s\n",file_contents);
    exit(0);
   }
   else{
    printf("Login Falied because \n%s\nTry Again!!!\n",response);
   }
  }
}