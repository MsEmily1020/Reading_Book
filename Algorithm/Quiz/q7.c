#include <stdio.h>

int main() {
	int j = 0, k = 1;
	do {
		j++;
		k *= j;
		
	} while(j < 5);
	
	printf("%d! = %d", j, k);
	return 0;
}
