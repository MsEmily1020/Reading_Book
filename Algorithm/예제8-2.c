#include <stdio.h>

int main(){
   int i;
   int *ip = &i;
   printf("정수입력: ");
   scanf("%d", &i);
   printf("결과 = %d\n",*ip+1);
   printf("주소값 = %d %d\n", ip, ip+1);
   
   printf("i의 크기는 %d\n", sizeof(i));
   printf("ip의 크기는 %d\n", sizeof(ip));
   
   return 0;
}
