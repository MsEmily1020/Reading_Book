#include <stdio.h>

int main(){
   int i, j;
   int *ip;
   printf("�����Է�: ");
   scanf("%d", &i);
   ip = &i;
   j = *ip;
   printf("j = %d\n",j);
   printf("i = %d ip= %d",i,ip); //*ip
   
   /*
   int i;
   int *ip = &i;
   printf("�����Է�: ");
   scanf("%d", &i);// ip�� �ּҰ� 
   printf("%d    %d ", *ip, ip); 
   */ 
   
   return 0;
}
