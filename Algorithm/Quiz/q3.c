#include <stdio.h>

int main() {
	int a = 2, n = 1, s = 0;
	do {
		s += a;
		a *= 3;
		n++;
	} while(n <= 4);
	
	printf("%d\n", s);
	return 0;
}
