#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<fcntl.h>
int main(){
char *p1="/tmp/fifo1",*p2="/tmp/fifo2";
int fd1,fd2;
char buf1[100],buf2[100];
mkfifo(p1,0666);
mkfifo(p2,0666);
fd1=open(p1,O_WRONLY);
fd2=open(p2,O_RDONLY);
printf("Say message to send\n");
scanf("%[^\n]s",buf1);
write(fd1,buf1,sizeof(buf1));
read(fd2,buf2,sizeof(buf2));
printf("The message is %s\n",buf2);
unlink(p1);
unlink(p2);
}
