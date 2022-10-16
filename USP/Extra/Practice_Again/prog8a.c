#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>
#include <sys/select.h>
int main(){
int fd[2];
pipe(fd);
int pid=fork();
if(pid==0){
close(fd[0]);
char msg[100];
printf("Child\nEnter MSG\n");
scanf("%[^\n]s",msg);
write(fd[1],msg,sizeof(msg));
}
else{
close(fd[1]);
fd_set fds;
struct timeval tv;
FD_ZERO(&fds);
FD_SET(fd[0],&fds);
tv.tv_sec=10;
tv.tv_usec=0;
int r=select(fd[0]+1,&fds,NULL,NULL,&tv);
if(r<0){
printf("Error in select ");
return -1;
}
else if(r>0){
char msg[100];
read(fd[0],msg,sizeof(msg));
printf("Message by child is: %s\n",msg);
}
else{
printf("No message from child for 10 sec\n");
return 0;
}
}
}
