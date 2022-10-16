#include<stdio.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include<sys/sem.h>
#include <sys/types.h>
#include<unistd.h>
int main(){
    struct sembuf sem_lock = { 0, -1, 0 },sem_unlock = { 0, 1, 0 };
    int semid;
    semid=semget(5,1,IPC_CREAT|0666);
    semctl(semid,0,SETVAL,1);
}
