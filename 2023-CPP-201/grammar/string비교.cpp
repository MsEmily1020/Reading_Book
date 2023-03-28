#include <stdio.h>
#include <string.h>

#include <iostream>
#include <string>

using namespace std;

int main() {
	char str1[50] = "Hello";
	char str2[50] = "World";

	// 함수 인자 위치와 결과값(-1, 1) 헷갈림
	int result = strcmp(str1, str2);
	if (result == -1) {
		printf("str2 > str1");
	}
	else if (result == 1) {
		printf("str2 < str1");
	}
	else if (result == 0) {
		printf("str1 == str2");
	}
	return 0;
}