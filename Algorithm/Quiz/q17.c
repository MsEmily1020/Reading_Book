#include <stdio.h>

int main() {
	int A[100][100];
	int i, j, k = 0, n;
	scanf("%d", &n);
	for(i = 1; i <= n; i++) {
		for(j = 1; j <= n; j++) {
			k++;
			A[i][j] = k;
		}
	}
	
	for(i = 1; i <= n; i++) {
		for(j = 1; j <= n; j++) {
			printf("%5d", A[i][j]);
		}
		printf("\n");
	}
	return 0;
}
