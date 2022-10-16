#include<stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
struct msgbuf {
long mtype;       
char mtext[100];    
};
int main(){
int msgid=msgget(1,0666);
while(msgid==-1)msgid=msgget(1,0666);
struct msgbuf msg;
scanf("%[^\n]s",msg.mtext);
msg.mtype=5;
msgsnd(msgid,&msg,sizeof(msg.mtext),IPC_NOWAIT);
while(msgrcv(msgid,&msg,sizeof(msg.mtext),6,IPC_NOWAIT)==-1);
printf("%s",msg.mtext);
}



