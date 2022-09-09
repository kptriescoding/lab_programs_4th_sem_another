#include <stdio.h> 
#include <string.h>
#include <unistd.h> 
#include <stdlib.h> 
#include <semaphore.h>
int main() 
{ 
	sem_t *sem = sem_open("SEMA55", 1);

        printf("Process P2 started\n");
       while(1){
        sem_wait(sem); 
        printf("This is a critical section of P2\n");
        printf("I will sleep for 1 secs now\n");
        fflush(stdout);
        sleep(1);
        printf("Sleep complete\n");
        fflush(stdout);
        sem_post(sem);
        printf("SLEEP 1s WITHOUT LOCK\n");
        sleep(1);
        printf("LOCK OVER\n");
       }
        
	return 0; 
} 

