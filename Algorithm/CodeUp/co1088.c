#include <stdio.h>

int main() {
	int i = 1, n;
	scanf("%d", &n);
	for(; i <= n; i++) {
		if(i % 3 == 0) continue;
		printf("%d ", i);
	}
	return 0;
}
