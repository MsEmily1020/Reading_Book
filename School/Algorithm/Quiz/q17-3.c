#include <stdio.h>

int main() {
	int m = 0, i, j;
	for(i = 0; i < 5; i++) {
		m = i + 1;
		for(j = 0; j < 5; j++) {
			printf("%3d", m);
			m+=5;
		}
		printf("\n");
	}
	return 0;
}
