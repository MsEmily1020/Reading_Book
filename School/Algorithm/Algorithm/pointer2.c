#include <stdio.h>

int main() {
	char k = 'A';
	char string1[] = "Hello World"; // 13Byte = 104bit
	char *string2 = "Hello World";
	char string3[12] = "Hello World";
	char string4[6] = {'H', 'e', 'l', 'l', 'o', '\0'};
	printf("%c %d\n", k, k);
	printf("%s\n", string1);
	printf("%s %d\n", string1, string1);
	printf("%s\n\n", string2);
	printf("%c %d\n", string2, string2);
	printf("%s\n", string3);
	printf("%s\n", string4);
	return 0;
} 
