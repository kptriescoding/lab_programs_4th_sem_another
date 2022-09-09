#include <stdio.h> 
#include <sys/ipc.h> 
#include <sys/msg.h> 
#include <string.h>
#include <unistd.h> 
#include <stdlib.h> 

#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h> 
#include <sys/sem.h>

int main(){
    int val = 0;
    printf("enter value:");
    scanf("%d",&val);
    
    
    // ftok to generate unique key 
	key_t key = ftok("shmfile",65); 

	// shmget returns an identifier in shmid 
	int shmid = shmget(key,1024,0666|IPC_CREAT); 
	// shmat to attach to shared memory 
	char *str = (char*) shmat(shmid,(void*)0,0); 

; 
    int semid = semget (key, 1, IPC_CREAT);
    
    struct sembuf *sem_lock = {0,-1, SEM_UNDO};
    struct sembuf *sem_unlock = {0,1, SEM_UNDO};    
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
    
    
    

	//printf("Write Data : "); 
	//gets(str); 

	//printf("Data written in memory: %s\n",str); 
	
	//detach from shared memory 
	//shmdt(str); 
  
    

    
   
    


}
