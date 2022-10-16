#include<stdio.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include<sys/sem.h>
#include <sys/types.h>
#include<unistd.h>

int main(){
int shmid,semid,has_waited=0;
char* shmstr;
shmid=shmget(1,4096,IPC_CREAT);
semid=semget(2,1,IPC_CREAT);
printf("Waiting for shared memory to be available\n");
while(semctl(semid,0,GETVAL)!=0)has_waited=1;
semctl(semid,0,SETVAL,1);
shmstr=(char*)shmat(shmid,NULL,0);
if(has_waited==1){
printf("Data written by other process is %s\n",shmstr);
semctl(semid,0,SETVAL,0);
return 0;
}
printf("Enter data to be written in shared memory\n");
scanf("%s",shmstr);
sleep(5);
printf("%s\nMemory is free\n",shmstr);
semctl(semid,0,SETVAL,0);
return 0;
}
