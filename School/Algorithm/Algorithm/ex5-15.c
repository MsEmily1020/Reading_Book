#include <stdio.h>
#define HELLO "I am glad to meet you."
#define PRINT printf("a = %d\n", a)

int main() {
	int a = 50;
	printf(HELLO);
	printf(PRINT);
	return 0;
}
