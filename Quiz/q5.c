#include <stdio.h>

int main() {
	int sum = 2, A = 1, B = 1, C, i = 2;
	while(i++ < 5) {
		C = A + B;
		sum += C;
		A = B;
		B = C;
	}
	printf("total = %dÀÔ´Ï´Ù.\n", sum);
	return 0;
}
