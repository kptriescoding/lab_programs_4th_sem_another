#include<stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include<fcntl.h>
#include<unistd.h>
int main(){
char* p="/tmp/fifo";
mkfifo(p,O_CREAT|0666);
int fd=open(p,O_WRONLY);
char msg[100];
printf("Enter message to send");
scanf("%[^\n]s",msg);
write(fd,msg,sizeof(msg));
close(fd);
unlink(p);
}
