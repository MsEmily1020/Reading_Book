#include <stdio.h>

int main() {
	int m = 0, i, j;
	printf("\n\n=======================================================\n\n");
	
	for(i = 0; i < 10; i++) {
		m = i + 1;
		for(j = 0; j < 10; j++) {
			printf("%5d", m);
			m = m + 10;
		}
		printf("\n");
	}
	
	printf("\n=======================================================\n\n");
	return 0;
}
