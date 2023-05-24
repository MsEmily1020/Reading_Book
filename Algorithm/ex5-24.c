#include <stdio.h>
#define square(x) x * x
#define square1(x) (x) * (x)

int main() {
	printf("5X5 = %d\n", square(3 + 2));
	printf("5X5 = %d\n", square1(3 + 2));
	return 0;
}
