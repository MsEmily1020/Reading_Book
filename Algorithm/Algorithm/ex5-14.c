#include <stdio.h>

int main() {
	int x = 0b1010;
	int y = 0b0110;
	int and = x & y;
	printf("%d\n", and);
	
	int or = x | y;
	printf("%d\n", or);
	
	int xor = x ^ y;
	printf("%d\n", xor);
	
	int not = ~x;
	printf("%d\n", not);
	
	int not1 = ~y;
	printf("%d\n", not1);
	
	
	return 0;
}
