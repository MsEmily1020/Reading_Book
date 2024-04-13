#include <stdio.h>

int main() {
	char ch, t = 'a';
	scanf("%c", &ch);
	do {
		printf("%c ", t);
		t++;
	} while(t < ch + 1);
	return 0;
} 
