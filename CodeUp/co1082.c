#include <stdio.h>

int main() {
	int ch, i;
	scanf("%x", &ch);
	for(i = 1; i <= 15; i++) {
		printf("%X*%X=%X\n", ch, i, (ch * i));
	}
	return 0;
} 
