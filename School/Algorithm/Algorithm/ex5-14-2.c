#include <stdio.h>

int main() {
	int a = 22, b = 016;		// 0001 0110
	printf("%d\n", a << 1);		// 0010 1100 --> 44
	printf("%d\n", a << 3);		// 1011 0000 --> 176
	printf("%d\n", a << 6);		// 0101 1000 0000
	printf("%d\n", a >> 1);		// a << b --> 2b승 만큼 곱해준다 
	printf("%d\n", a >> 3);
	printf("%d\t %o\t %o\t %x\t\n", b << 1, b << 2, b << 3, b << 1);
	// b --> 8진법 16
	// 		10진법 14 -> 28
	//	    10진법 56 -> 8진법 70 
	// b --> 16진법 1c 
	return 0;
}
