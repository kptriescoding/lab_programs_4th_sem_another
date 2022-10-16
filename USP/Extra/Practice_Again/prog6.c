#include<stdio.h>
#include<signal.h>
 #include <sys/types.h>
  #include <unistd.h>

void handle_func(int signo){
switch(signo){
case SIGINT:
printf("SIGINT was detected\n");
break;
case SIGFPE:
printf("SIGFPE was detected\n");
break;
case SIGCHLD:
printf("SIGCHLD was detected\n");
break;
case SIGILL:
printf("SIGILL was detected\n");
break;
case SIGSEGV:
printf("SIGINT was detected\n");
break;
default:
printf("SIGINT was detected\n");
break;
}
}
int main(){
printf("%d\n",getpid());
signal(SIGINT,handle_func);
signal(SIGFPE,handle_func);
signal(SIGILL,handle_func);
signal(SIGSEGV,handle_func);
signal(SIGCHLD,handle_func);
while(1);
}
