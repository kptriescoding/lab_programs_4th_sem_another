#include<stdio.h>
#include<signal.h>
#include<unistd.h>
void handler_func(int signo){
switch(signo){
case SIGINT:
printf("SIGINT signals was caught\n");
break;
case SIGFPE:
printf("SIGFPE signals was caught\n");
break;
case SIGCHLD:
printf("SIGCHLD signals was caught\n");
break;
case SIGSEGV:
printf("SIGSEGV signals was caught\n");
break;
case SIGILL:
printf("SIGILL signals was caught\n");
break;
}
}
int main(){
printf("The process pid is %d\n",getpid());
signal(SIGINT,handler_func);
signal(SIGFPE,handler_func);
signal(SIGCHLD,handler_func);
signal(SIGSEGV,handler_func);
signal(SIGILL,handler_func);
while(1);
}
