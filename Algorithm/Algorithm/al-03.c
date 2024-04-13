#include <stdio.h>

int main() {
	int i = 1, sum = 0;
	for(; i <= 100; i++) {
		if(i % 2 != 0) sum += i;
	}
	
	printf("sum = %d\n", sum);
	return 0;
}
