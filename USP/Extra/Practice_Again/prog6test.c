#include<signal.h>
#include<sys/types.h>
int main(){
int pid=6884;
kill(pid,SIGINT);
kill(pid,SIGFPE);
kill(pid,SIGSEGV);
kill(pid,SIGCHLD);
kill(pid,SIGILL);
}
