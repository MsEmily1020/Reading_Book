#include <stdio.h>
#include <string.h>

#include <iostream>
#include <string>

using namespace std;

int main() {
	char str1[50] = "Hello";
	char str2[50] = "World";

	const int s1_len = strlen(str1);
	const int s2_len = strlen(str2);

	// s1_len과 s2_len 중 작은 값을 선택
	const int len = s1_len < s2_len ? s1_len : s2_len;

	int i;
	for (i = 0; i < len; i++) {
		if (str2[i] > str1[i]) {
			printf("str2 > str1 \n");
			break;
		}

		else if (str1[i] > str2[i]) {
			printf("str1 > str2 \n");
			break;
		}
	}

	if (i == len) {
		if (s2_len > s1_len) {
			printf("str2 > str1 \n");
		}

		else if (s1_len > s2_len) {
			printf("str1 > str2 \n");
		}

		else {
			printf("str1 == str2");
		}
	}
	return 0;
}