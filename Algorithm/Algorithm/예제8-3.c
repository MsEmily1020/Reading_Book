#include <stdio.h>

int main(){
   int a[5] = {2100000000, 200, 300, 400, 500};
   int *ip = a; // �迭�� �ּҰ� a ��. *ip=a�� ����
   int i;
   printf("%d\n", a[2]);
   for(i=0; i<=4; i++)
     printf("a[%d] = %d, �ּ� = %x\n", i, *(ip+i), &a[i]);
     printf("%x %x %x\n", ip, ip + 1, ip + 2);
     
	return 0;
}
