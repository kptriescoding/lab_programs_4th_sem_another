#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<fcntl.h>
#include<sys/time.h>
int main(){
int fd[2];
pipe(fd);
int pid=fork();
if(pid<0)exit(-1);
else if(pid==0){
char buf[1000];
printf("Enter the messasge to be sent to parent\n");
scanf("%[^\n]s",buf);
write(fd[1],buf,sizeof(buf));
exit(0);
}
fd_set fds;
char buf[1000];
struct timeval tv;
tv.tv_sec=5;
tv.tv_usec=0;
FD_ZERO(&fds);
FD_SET(fd[0],&fds);
int r=select(fd[0]+1,&fds,NULL,NULL,&tv);
if(r==-1)printf("Error in select\n");
else if(r>0){
read(fd[0],buf,sizeof(buf));
printf("The data sent by by child is %s\n",buf);
}
else printf("No message was sent\n");
}
