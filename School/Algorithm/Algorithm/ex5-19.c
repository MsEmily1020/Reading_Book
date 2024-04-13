#include <stdio.h>
#define ABS(x) (x > 0) ? x : -x

int main() {
	int i;
	printf("정수 입력 : ");
	scanf("%d", &i);
	printf("\n|%d| = %d\n", i, ABS(i));
	return 0;
}
