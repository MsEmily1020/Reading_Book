#include <stdio.h>

int main() {
	long long int a, m, d, n;
	scanf("%ld %ld %ld %ld", &a, &m, &d, &n);
	while(n > 1) {
		a = a * m + d;
		n--;
	}
	
	printf("%ld", a);
	return 0;
}
