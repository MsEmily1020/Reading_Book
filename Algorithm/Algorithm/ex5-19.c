#include <stdio.h>
#define ABS(x) (x > 0) ? x : -x

int main() {
	int i;
	printf("���� �Է� : ");
	scanf("%d", &i);
	printf("\n|%d| = %d\n", i, ABS(i));
	return 0;
}
