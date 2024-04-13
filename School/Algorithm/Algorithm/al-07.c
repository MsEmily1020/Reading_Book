#include <stdio.h>

int main() {
	int a = 2, b = 6, s = 0, n = 1;
	do {
		s += a;
		a += b;
		n++;
	} while(n <= 5);
	
	printf("%d\n", s);
	return 0;
}
