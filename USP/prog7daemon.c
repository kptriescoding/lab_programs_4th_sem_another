#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <syslog.h>
#include <shadow.h>
#include<crypt.h>
#include<string.h>
#include <fcntl.h>
 char* p1="/tmp/fifo1",*p2="/tmp/fifo2";
 int fd1,fd2;
    char username[1000],pass[1000],us_pass[1000],response[1000];
int handle_login(){
    syslog (LOG_NOTICE, "Daemon Process waiting for response from user");
    read(fd1,us_pass,sizeof(us_pass));
    int i=0,j=0;
    while(us_pass[i]!='$')username[j++]=us_pass[i++];
    i++;
    j=0;
    while(us_pass[i]!='$')pass[j++]=us_pass[i++];
    syslog(LOG_NOTICE,"Got username and password from user");
struct spwd *user=getspnam(username);
if(user==NULL){
strcpy(response,"Username Invalid or shadow command failed due insufficient access");
 write(fd2,response,sizeof(response));
 syslog (LOG_NOTICE, "Daemon Process exiting due to insufficient permissions");
return -1;
}
char* passwd=user->sp_pwdp;
char salt[50];
for(int i=0;i<20;i++)salt[i]=passwd[i];
char* upasswd=crypt(pass,salt);
if(strcmp(passwd,upasswd)==0){
strcpy(response,"Password is Correct Access Granted");
write(fd2,response,sizeof(response));
return 1;
}
else{
strcpy(response,"Incorrect Password Access Denied");
write(fd2,response,sizeof(response));
syslog (LOG_NOTICE, "Daemon Process starting login process once again");
return -1;
}
}
void skeleton_daemon()
{
    pid_t pid;
    pid = fork();
    if (pid < 0)
        exit(EXIT_FAILURE);
    if (pid > 0)
        exit(EXIT_SUCCESS);
    if (setsid() < 0)
        exit(EXIT_FAILURE);
    signal(SIGCHLD, SIG_IGN);
    signal(SIGHUP, SIG_IGN);
    pid = fork();
    if (pid < 0)
        exit(EXIT_FAILURE);
    if (pid > 0)
        exit(EXIT_SUCCESS);
    umask(0);
    int x;
    for (x = sysconf(_SC_OPEN_MAX); x>0; x--)
    {
        close (x);
    }
    openlog ("filedaemon", LOG_PID, LOG_DAEMON);
}
int main()
{
    skeleton_daemon();
        syslog (LOG_NOTICE, "File Monitoring Daemon process started.");
        mkfifo(p1,0666);
        mkfifo(p2,0666);
        fd1=open(p1,O_RDONLY);
        fd2=open(p2,O_WRONLY);
        syslog (LOG_NOTICE, "Fifo files created and monitoring started");
        while(1){
            int rv=handle_login();
            if(rv==1)
            break;
        }
    syslog (LOG_NOTICE, "File Monitoring daemon ended terminated.");
    closelog();
    close(fd1);
    close(fd2);
    unlink(p1);
    unlink(p2);
    return EXIT_SUCCESS;
}
