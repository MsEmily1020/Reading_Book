#include <stdio.h>
#include <string.h>

#include <iostream>
#include <string>

using namespace std;

int main() {
	char str1[30] = "Jiwoo";
	char str2[30] = "Rock";

	const int str1_len = strlen(str1);
	const int str2_len = strlen(str2);

	for (int i = str1_len; i < str1_len + str2_len; i++) {
		str1[i] = str2[i - str1_len];
	}

	printf("%s\n", str1);
}