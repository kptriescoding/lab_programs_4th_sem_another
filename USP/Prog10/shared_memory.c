#include <stdio.h> 
#include <sys/ipc.h> 
#include <sys/msg.h> 
#include <string.h>
#include <unistd.h> 
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h> 
#include <sys/sem.h>
#include<errno.h>
void parent(){
	int val = 0;
    printf("enter value:");
    scanf("%d",&val);
	key_t key = ftok("test-file",17); 
	int shmid = shmget(key,1024,0666|IPC_CREAT); 
	char *str = (char*) shmat(shmid,(void*)0,0); 
    int semid = semget (key, 1, IPC_CREAT);
    struct sembuf sem_lock = {0,-1, SEM_UNDO};
    struct sembuf sem_unlock = {0,1, SEM_UNDO};    
    int x = 99;
    semctl(semid,0, SETVAL,5);
    while(1){
        x = semctl( semid,0, GETVAL);
        if(x==5){
        printf("semaphore locked \nACCESS %d\n",val);
        printf("going to sleep for 5s\n");
        sleep(5);
        printf("sleep complete");
        semctl(semid,0, SETVAL,0);
        printf("semaphore unlocked");
        }
        else{
        printf("%d its busy try after 1s\n",x);
        sleep(1);
        }
    }
}
void child(){
	int val = 0;
    printf("enter value:");
    scanf("%d",&val);
	key_t key = ftok("test-file",17); 
	int shmid = shmget(key,1024,0666|IPC_CREAT); 
	char *str = (char*) shmat(shmid,(void*)0,0); 
    int semid = semget (key, 1, IPC_CREAT);
    struct sembuf sem_lock = {0,-1, SEM_UNDO};
    struct sembuf sem_unlock = {0,1, SEM_UNDO};    
    int x = 99;
    semctl(semid,0, SETVAL,5);
    while(1){
        x = semctl( semid,0, GETVAL);
        if(x==5){
        printf("semaphore locked \nACCESS %d\n",val);
        printf("going to sleep for 5s\n");
        sleep(5);
        printf("sleep complete");
        semctl(semid,0, SETVAL,0);
        printf("semaphore unlocked");
        }
        else{
        printf("%d its busy try after 1s\n",x);
        sleep(1);
        }
    }
}
union semun  {
          int val;
           struct semid_ds *buf;
          ushort *array;
    } arg;
int main(){
	extern int errno;
	key_t key =ftok("testfile",17334);
	printf("%d\n",key);
	int shmid=shmget(key,4096,IPC_CREAT|0666);
	printf("%d\n",shmid);
	char *shmstr=(char*)shmat(shmid,(void*)0,0);
	printf("%ld\n",sizeof(shmstr));
	int semid=semget(key,1,IPC_CREAT);
	printf("%d\n",semid);
	arg.val=5;
	int s=semctl(semid,0,SETVAL,arg);
	printf("%d\n",s);
	printf("%s\n",strerror(errno));
    while(1){
        int x = semctl( semid,0, GETVAL);
        if(x==5){
        printf("semaphore locked \nACCESS %d\n",semid);
        printf("going to sleep for 5s\n");
        sleep(5);
        printf("sleep complete");
        semctl(semid,0, SETVAL,0);
        printf("semaphore unlocked");
        }
        else{
        printf("%d its busy try after 1s\n",x);
		printf("%d\n",errno);
		printf("%s\n",strerror(errno));
        sleep(1);
        }
    }
}