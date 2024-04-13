#include <stdio.h>

int main() {
	int x, y;
	printf("x = ");		scanf("%d", &x);
	printf("y = ");		scanf("%d", &y);
	
	printf("%s", (x >= 100) && (x + y > 0) ? "A class" : (x + y < 0) ? "B class" : "C class");
	return 0;
}
