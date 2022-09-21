#include<stdio.h>
#include<setjmp.h>
jmp_buf buf1,buf2;
void func2(){
printf("In function 2\n");
longjmp(buf2,2);
}
void func1(){
printf("In function 1\n");
int r=setjmp(buf2);
if(r==2){
printf("Returned from function 2\n");
longjmp(buf1,1);
return;
}
printf("Calling function 2\n");
func2();
}
int main(){
int r=setjmp(buf1);
if(r==1){
printf("Returned from fuction 1\n");
}
else {
printf("In main function\nCalling function 1\n");
func1();
}
}
