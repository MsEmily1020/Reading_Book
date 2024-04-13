#include <stdio.h>

int main() {
	long long int a, r, n, i = 1;
	scanf("%ld %ld %ld", &a, &r, &n);
	for(; i < n; i++) {
		a *= r;
	}

	printf("%ld", a);	
	return 0;
}
