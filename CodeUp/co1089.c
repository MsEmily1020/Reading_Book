#include <stdio.h>

int main() {
	int a, d, n;
	scanf("%d %d %d", &a, &d, &n);
	while(n > 1) {
		n--;
		a += d;
	}
	
	printf("%d", a);
	return 0;
}
