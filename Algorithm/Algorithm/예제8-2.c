#include <stdio.h>

int main(){
   int i;
   int *ip = &i;
   printf("�����Է�: ");
   scanf("%d", &i);
   printf("��� = %d\n",*ip+1);
   printf("�ּҰ� = %d %d\n", ip, ip+1);
   
   printf("i�� ũ��� %d\n", sizeof(i));
   printf("ip�� ũ��� %d\n", sizeof(ip));
   
   return 0;
}
