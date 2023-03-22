#include <stdio.h> 

int main() {
	int i = 1, sum = 0;
	for(; i <= 100; i++) {
		switch(i % 2) {
			case 0 :
				sum -= i;
				break;
			default :
				sum += i;
		}
	}
	
	printf("sum = %d\n", sum);
	return 0;
} 
