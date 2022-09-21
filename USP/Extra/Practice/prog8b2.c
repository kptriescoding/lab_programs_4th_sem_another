#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<fcntl.h>
int main(){
char *p1="/tmp/fifo1",*p2="/tmp/fifo2";
int fd1,fd2;
fd1=open(p1,O_RDONLY);
fd2=open(p2,O_WRONLY);
char buf1[1000],buf2[1000];
read(fd1,buf1,sizeof(buf1));
printf("The message is %s\n",buf1);
printf("Say message to send\n");
scanf("%[^\n]s",buf2);
write(fd2,buf2,sizeof(buf2));
}
