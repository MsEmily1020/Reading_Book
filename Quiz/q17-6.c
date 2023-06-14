#include <stdio.h>

int main() {
	int m = 0, c, i, j;
	for(i = 1; i <= 5; i++) {
		c = i;
		for(j = 1; j <= 5; j++) {
			if(j % 2 == 0)
				m = -1 + 2 * i;
			else
				m = 11 - 2 * i;
			printf("%3d", c);
			c += m;
		}
		
		printf("\n");
	}
	return 0;
}
