#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <syslog.h>
#include <pwd.h>
#include <shadow.h>
#include<crypt.h>
#include<string.h>
#include <fcntl.h>
#include <sys/ipc.h>
#include <sys/msg.h>

struct message
{
long mtype;
char mtext[100];
};
int msgid,len;
int handle_locks(){
    struct message *msgbuf=(struct message*)malloc(sizeof(struct message));
key_t key=1;
msgid=msgget(key,IPC_CREAT|0666);
    syslog (LOG_NOTICE, "Daemon Process waiting for fileaccess");
   
    while(msgrcv(msgid,msgbuf,sizeof(msgbuf->mtext),1,IPC_NOWAIT)==-1);
    syslog(LOG_NOTICE,"Process requesting access");
strcpy(msgbuf->mtext,"Enter the username");
 msgbuf->mtype=2;
    msgsnd(msgid,msgbuf,sizeof(msgbuf->mtext),IPC_NOWAIT);
     while(msgrcv(msgid,msgbuf,sizeof(msgbuf->mtext),1,IPC_NOWAIT)==-1);
     printf("%s\n",msgbuf->mtext);
struct spwd *user=getspnam(msgbuf->mtext);
if(user==NULL){
     msgbuf->mtype=2;
strcpy(msgbuf->mtext,"Username Invalid or shadow command failed due insufficient access\n");
     msgsnd(msgid,msgbuf,sizeof(msgbuf->mtext),IPC_NOWAIT);
return -1;
}
char* passwd=user->sp_pwdp;
char salt[50];
for(int i=0;i<20;i++)salt[i]=passwd[i];
 msgbuf->mtype=2;
strcpy(msgbuf->mtext,"Enter the password");
msgsnd(msgid,msgbuf,sizeof(msgbuf->mtext),IPC_NOWAIT);
    //  printf("%s\n",msgbuf->mtext);
       while(msgrcv(msgid,msgbuf,sizeof(msgbuf->mtext),1,IPC_NOWAIT)==-1);
        //  printf("%s\n",msgbuf->mtext);
char* upasswd=crypt(msgbuf->mtext,salt);
// printf("%s\n%s\n",passwd,upasswd);
if(strcmp(passwd,upasswd)==0){
strcpy(msgbuf->mtext,"Password is Correct Access Granted");
 msgbuf->mtype=2;
msgsnd(msgid,msgbuf,sizeof(msgbuf->mtext),IPC_NOWAIT);
return 1;
}
else{
strcpy(msgbuf->mtext,"Incorrect Password Access Denied");
 msgbuf->mtype=2;
msgsnd(msgid,msgbuf,sizeof(msgbuf->mtext),IPC_NOWAIT);
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
        syslog (LOG_NOTICE, "File has been locked");
        while(1){
            int rv=handle_locks();
            if(rv==1)
            break;
        }
    syslog (LOG_NOTICE, "File Monitoring daemon ended terminated.");
    closelog();
msgctl(msgid,IPC_RMID,NULL);
    return EXIT_SUCCESS;
}
