#include <stdio.h>

int main() {
	int i, sum;
	i = 0; sum = 0;
	do {
		i++;
		sum += i;
		if(i == 10) break;
	} while(1);
	printf("1-100ÀÇ ÇÕ = %d\n", sum);
}
