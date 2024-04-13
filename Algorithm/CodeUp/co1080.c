#include <stdio.h>

int main() {
	int sum = 0, i = 1, n;
	scanf("%d", &n);
	for(; sum < n; i++) sum += i;
	printf("%d", i - 1);
	return 0;
}
