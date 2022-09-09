#include <stdio.h> 
#include <string.h>
#include <unistd.h> 
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h> 
#include <semaphore.h>
int main() 
{ 
	sem_t *sem = sem_open("SEMA55", O_CREAT, 0644, 1); /* Initial value is 1. */
        sem_post(sem);
        printf("Process P1 started\n");
       
        while(1){
        printf("|");
        sem_wait(sem); 
        printf("This is a critical section of P1\n");
        printf("SLEEP 5s WITH LOCK\n");
        fflush(stdout);
        sleep(5);
        printf("LOCK OVER\n");
        fflush(stdout);
        sem_post(sem); 
        printf("SLEEP 5s WITHOUT LOCK\n");
        sleep(5);
        printf("LOCK OVER\n");
        }
        
	return 0; 
} 

