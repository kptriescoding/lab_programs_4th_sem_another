#include<stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include<sys/types.h>
#include<sys/stat.h>
int main(){
int fd;
mkfifo("/tmp/fifo",0666);
fd=open("/tmp/fifo",O_RDWR);
char buf[1000];
int count=1000;
printf("Waiting for Process 2 to write into fifo file\n");
read(fd, buf,count);
printf("Message from process 2 : %s\n",buf);
char buf2[1000]="Some Message";
printf("Process 1 writing in fifo file\n");
write(fd, buf2,sizeof(buf2));
exit(0);
}
