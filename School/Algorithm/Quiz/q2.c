#include <stdio.h>

int main() {
	int a = 2, s = 0, n = 1;
	do {
		s += a;
		a += 6;
		n++;
	} while(n <= 200);
	
	printf("%d\n", s);
	return 0;
}
