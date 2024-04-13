#include <stdio.h>

int main() {
	int i = 0, s = 0;
	while(i < 5) {
		i++;
		s += i;
	}
	
	printf("sum = %d\n", s);
	return 0;
}
