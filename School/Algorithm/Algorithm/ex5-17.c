#include <stdio.h>
#define ADD(x, y) x + y
#define MULTI(x, y) x * y

int main() {
	int a = 10, b = 20;
	printf("a = %d, b = %d\n", a, b);
	printf("ADD => %d\n", ADD(a, b));
	printf("MULTI => %d\n", MULTI(a, b));
	return 0;
}
