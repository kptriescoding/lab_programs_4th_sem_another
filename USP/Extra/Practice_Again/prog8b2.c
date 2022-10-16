#include<stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include<fcntl.h>
#include<unistd.h>
int main(){
char* p="/tmp/fifo";
int fd=open(p,O_RDONLY);
char msg[100];
read(fd,msg,sizeof(msg));
printf("Message recieved is %s\n",msg);
close(fd);
}
