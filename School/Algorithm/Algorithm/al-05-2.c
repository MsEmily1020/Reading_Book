#include <stdio.h>

int main () {
	int i = 0, sw = 0, sum = 0;
	while(i < 10) {
		i++;
		if(sw == 0) {
			sum += i;
			sw = 1;
		}
		
		else {
			sum += i;
			sw = 0;
		}
	}
	
	printf("sum = %d\n", sum);
	return 0;
} 
