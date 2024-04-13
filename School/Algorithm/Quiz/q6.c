#include <stdio.h>

int main() {
	int N, i, j;
	scanf("%d", &N);
	
	for(i = 2; i <= N; i++) {
		while(N % i == 0) {
			printf("%d\n", i);
			N /= i;
		}
	}
	return 0;
}
