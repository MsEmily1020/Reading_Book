#include <stdio.h>

int main() {
	int a = 3;
	int *p1 = &a;
	printf("%d %d %d", *p1, p1, &a);
	return 0;
}
