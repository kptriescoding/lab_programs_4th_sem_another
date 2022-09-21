#include<stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include<stdlib.h>
#include<string.h>
struct message {
 long mtype;
char mtext[100];    
};

int main(){
struct message msg1;
key_t key=1;
int msgid=msgget(key,0666);
while(msgid==-1){
msgid=msgget(key,0666);
}
msg1.mtype=1;
printf("Send\n");
scanf("%[^\n]s",msg1.mtext);
printf("%d\n",msgsnd(msgid,&msg1,sizeof(msg1.mtext),IPC_NOWAIT));
while(msgrcv(msgid,&msg1,sizeof(msg1.mtext),2,IPC_NOWAIT)==-1);
printf("%s\n",msg1.mtext);
}
