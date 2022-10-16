#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>
#include<sys/wait.h>
#include<stdlib.h>
int main(){
int pid=fork();
if(pid<0)printf("Fork Fail\n");
else if(pid==0){
printf("Child\nEnter command\n");
char cmd[1000];
scanf("%[^\n]s",cmd);
printf("%s",cmd);
system(cmd);
printf("Child Exiting %d %d\n",getpid(),getppid());
}
else{
printf("Parent\nWaiting for child\n");
wait(NULL);
printf("Return to parent %d %d\n",pid,getpid());
} 
}
