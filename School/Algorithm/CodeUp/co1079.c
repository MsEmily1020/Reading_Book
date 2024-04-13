#include <stdio.h>

int main() {
	while(1) {
		char ch;
		scanf("%c", &ch);
		if(ch != ' ') printf("%c\n", ch);
		if(ch == 'q') break;
	}
	return 0;
}
