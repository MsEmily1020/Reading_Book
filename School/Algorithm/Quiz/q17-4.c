#include <stdio.h>

int main() {
	int a[10][10];
	int n, num = 1;
	int i, j;
	scanf("%d", &n);
	for(i = 1; i <= n; i++) {
		for(j = 1; j <= n; j++) {
			a[j][i] = num;
			num += 2;
		}
	}
	
	for(i = 1; i <= n; i++) {
		for(j = 1; j <= n; j++) {
			printf("%d ", a[i][j]);
		}
		printf("\n");
	}
	return 0;
}
