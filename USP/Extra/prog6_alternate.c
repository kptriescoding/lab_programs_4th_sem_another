#include<stdio.h>
#include<signal.h>
#include<stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
#include<setjmp.h>

jmp_buf buf;

void handler_func(int signum){
switch(signum){
case SIGINT:
printf("\nInterrupt by Keyboard has taken place\nSignal No is %d\n",SIGINT);
longjmp(buf,1);
break;
case SIGFPE:
printf("Floating Point Exception Has Occured\nSignal No is %d\n",SIGFPE);
longjmp(buf,2);
break;
case SIGSEGV:
printf("Invalid memory refernce signal has taken place\nSignal No is %d\n",SIGSEGV);
longjmp(buf,3);
break;
case SIGCHLD:
printf("Child process has terminated\nSignal No is %d\n",SIGCHLD);
longjmp(buf,4);
break;
case SIGILL:
printf("Illegal Instruction\nSignal No is %d\n",SIGILL);
longjmp(buf,5);
break;
default:
printf("Some other signal\n");
}
return;
}

int main(){
signal(SIGINT,handler_func);
signal(SIGFPE,handler_func);
signal(SIGSEGV,handler_func);
signal(SIGCHLD,handler_func);
signal(SIGILL,handler_func);
int val=setjmp(buf);
switch(val){
case 0:
printf("Testing interupt by keyboard\n");
sleep(123);
case 1:
printf("\nTesting Floating point exception\n");
int c=0;
int b=4/c;
break;
case 2:
printf("\nTesting invalid memory reference signal\n");
int *arr=NULL;
int a=arr[3];
break;
case 3:
printf("\nTesting for child termination\n");
int n = fork();
    if(n == 0)
    {
        printf("This is the child process and is exiting\n");
       exit(0);
    }
    wait(NULL);
 break;
case 4:
printf("\nTesting for Illegal Instruction\n");
asm("ud2");
break;
default:
printf("All Tests done\n");
}
}