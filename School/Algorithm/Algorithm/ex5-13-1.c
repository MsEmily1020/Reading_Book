#include <stdio.h>

int main() {
	int x, y;
	printf("x = ");		scanf("%d", &x);
	printf("y = ");		scanf("%d", &y);
	
	if((x >= 100) && (x + y > 0)) printf("A class");
	else if (x + y < 0) printf("B class");
	else printf("C class");
	return 0;
}
