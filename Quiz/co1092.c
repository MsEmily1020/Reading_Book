#include <stdio.h>

int main() {
	int p1, p2, p3;
	scanf("%d %d %d", &p1, &p2, &p3);
	int day = 1;
	while(day % p1 != 0 || day % p2 != 0 || day % p3 != 0) day++;
	printf("%d", day);
	return 0;
}
