#include<stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
struct msgbuf {
long mtype;       
char mtext[100];    
};
int main(){
int msgid=msgget(1,IPC_CREAT|0666);
struct msgbuf msg;
while(msgrcv(msgid,&msg,sizeof(msg.mtext),5,IPC_NOWAIT)==-1);
printf("Message recived %s\n",msg.mtext);
scanf("%[^\n]s",msg.mtext);
msg.mtype=6;
msgsnd(msgid,&msg,sizeof(msg.mtext),IPC_NOWAIT);
msgctl(msgid,IPC_RMID,NULL);
}



