#include <stdio.h>

int main() {
	int A, B, sum = 0;
	printf("첫번째 수 : ");
	scanf("%d", &A);
	printf("두번째 수 : ");
	scanf("%d", &B);
	if(A > B) {
		int tmp = A;
		A = B;
		B = tmp;
	}
	while(A <= B) {
		sum += A++;
	}
	printf("%d", sum);
	return 0;
}
