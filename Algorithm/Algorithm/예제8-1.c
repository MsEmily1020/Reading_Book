#include <stdio.h>

int main(){
   int i, j;
   int *ip;
   printf("정수입력: ");
   scanf("%d", &i);
   ip = &i;
   j = *ip;
   printf("j = %d\n",j);
   printf("i = %d ip= %d",i,ip); //*ip
   
   /*
   int i;
   int *ip = &i;
   printf("정수입력: ");
   scanf("%d", &i);// ip는 주소값 
   printf("%d    %d ", *ip, ip); 
   */ 
   
   return 0;
}
