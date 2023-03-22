#include <stdio.h>

int main() {
	int a = 2, d = 6, s = a, n = 2, an = 0;
	do {
		an = a + (n - 1) * d;
		s += an;
		n++;
	} while(n <= 200);
	
	printf("%d\n", s);
	return 0;
} 
