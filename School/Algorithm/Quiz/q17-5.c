#include <stdio.h>

int main() {
	int A[10][10];
	int n, i, j;
	scanf("%d", &n);
	int x = 1;
	for(i = 1; i <= n; i++) {
		if(i % 2 == 1) {
			for(j = 1; j <= n; j++) {
				A[j][i] = x;
				x++;
			}
		}
		
		else {
			for(j = n; j >= 1; j--) {
				A[j][i] = x;
				x++;
			}
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
