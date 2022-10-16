#include<stdio.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include<sys/sem.h>
#include <sys/types.h>
#include<unistd.h>
int main(){
    struct sembuf sem_lock = { 0, -1, 0 },sem_unlock = { 0, 1, 0 };
int shmid,semid,has_waited=0;
char* shmstr;
shmid=shmget(1,4096,IPC_CREAT);
semid=semget(5,1,IPC_CREAT|0666);
printf("Waiting for shared memory to be available\n");
int x=semop(semid,&sem_lock,1);
shmstr=(char*)shmat(shmid,NULL,0);
printf("Enter data to be written in shared memory\n");
scanf("%s",shmstr);
sleep(5);
printf("%s\nMemory is free\n",shmstr);
semop(semid,&sem_unlock,1);
return 0;
}
