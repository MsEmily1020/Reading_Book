#include <stdio.h>

int main() {
	int N = 0, sum = 0, i = 1;
	for(; i <= 20; i++) {
		if(i % 3 == 0) {
			N++;
			sum += i;
			printf("3의 배수 = %d\n", i);
		}
	}
	
	printf("개수 = %d, sum = %d", N, sum);
	return 0;
}
