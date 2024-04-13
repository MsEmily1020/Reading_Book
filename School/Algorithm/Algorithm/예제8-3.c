#include <stdio.h>

int main(){
   int a[5] = {2100000000, 200, 300, 400, 500};
   int *ip = a; // 배열의 주소가 a 임. *ip=a도 동일
   int i;
   printf("%d\n", a[2]);
   for(i=0; i<=4; i++)
     printf("a[%d] = %d, 주소 = %x\n", i, *(ip+i), &a[i]);
     printf("%x %x %x\n", ip, ip + 1, ip + 2);
     
	return 0;
}
