#include <stdio.h>     
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include<stdlib.h>
#include<sys/ipc.h>
#include<sys/msg.h>
#include<string.h>
struct message
{
long mtype;
char mtext[100];
};
int main()
{
  struct message *msgbuf=(struct message*)malloc(sizeof(struct message));
int msgid;
key_t key=1;
msgid=msgget(key,0666);
while(msgid==-1){
msgid=msgget(key,0666);
}
msgbuf->mtype=1;
    strcpy(msgbuf->mtext,"Need File Access");
msgsnd(msgid,msgbuf,sizeof(msgbuf->mtext),IPC_NOWAIT);
  while(1)
  {
    while(msgrcv(msgid,msgbuf,sizeof(msgbuf->mtext),2,IPC_NOWAIT)==-1);
    printf("Message from daemon is\n %s\n",msgbuf->mtext);
    if(strcmp(msgbuf->mtext,"Password is Correct Access Granted")==0){
      int fd=open("test-file",O_RDWR);
      char buf[100];
      read(fd,buf,sizeof(buf));
      printf("The contents of file are\n %s\n",buf);
      break;
    }
    printf(" Enter your response\n");
    scanf("%s",msgbuf->mtext);
    msgbuf->mtype=1;
   msgsnd(msgid,msgbuf,sizeof(msgbuf->mtext),IPC_NOWAIT);
  }
}