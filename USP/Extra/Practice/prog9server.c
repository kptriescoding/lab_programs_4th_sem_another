#include<stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include<stdlib.h>
#include<string.h>
#include<errno.h>
struct message {
 long mtype;
char mtext[100];    
};
extern int errno;
int main(){
struct message msg1;
key_t key=1;
int msgid=msgget(key,IPC_CREAT|0666);
printf("Waiting for recieving\n");
while(msgrcv(msgid,&msg1,sizeof(msg1.mtext),1,IPC_NOWAIT)==-1);
printf("%s\n",msg1.mtext);
printf("Send\n");
scanf("%[^\n]s",msg1.mtext);
msg1.mtype=2;
msgsnd(msgid,&msg1,sizeof(msg1.mtext),IPC_NOWAIT);
msgctl(msgid,IPC_RMID, NULL);
}
