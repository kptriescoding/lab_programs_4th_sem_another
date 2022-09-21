#include<stdio.h>
#include<sys/types.h>
#include<signal.h>
int main(){
pid_t pid=21335;
kill(pid,SIGINT);
kill(pid,SIGFPE);
kill(pid,SIGCHLD);
kill(pid,SIGILL);
kill(pid,SIGSEGV);
}
