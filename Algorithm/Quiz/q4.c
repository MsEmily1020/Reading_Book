#include <stdio.h>

int main() {
	int A, B, sum = 0;
	printf("ù��° �� : ");
	scanf("%d", &A);
	printf("�ι�° �� : ");
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
