#include<stdio.h>
#include<setjmp.h>
jmp_buf buf1,buf2;
void func2(){
printf("In func2\n");
longjmp(buf2,3);
}
void func1(){
int v=setjmp(buf2);
if(v==3){
printf("Return from func2\n");
longjmp(buf1,2);
}
printf("In func1\n");
func2();
}
int main(){
int v=setjmp(buf1);
if(v==2){
printf("Return from func1\n");
return 0;
}
printf("In main\n");
func1();
}
