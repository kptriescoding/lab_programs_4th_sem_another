#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/wait.h>
int main(){
int pid=fork();
if(pid<0){
printf("The fork function failed\n");
return 0;
} 
else if(pid==0){
printf("In child process\nEnter the command to be executed\n");
char cmd[100];
scanf("%[^\n]s",cmd);
printf("The output of the command is \n");
system(cmd);
printf("The childprocess pid is %d\nThe parent process pid is %d\nChild Exiting.. \n",getpid(),getppid());
return 0;
}
else if(pid>0){
printf("In Parent Process\nThe parent is waiting for child to finish...\n");
wait(NULL);
printf("Returned from child process\nThe childprocess pid is %d\nThe parent process pid is %d\nParent exiting.. \n",pid,getpid());
return 0;
}
}
