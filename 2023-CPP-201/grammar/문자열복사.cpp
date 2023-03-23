#include <iostream>
#include <string.h> // 문자열 관련 함수

using namespace std;

int main() {
	char str[30] = { 0 };
	char str2[30] = "c_insert";

	strcpy(str, str2); //str에 str2에 있는 문자열 복사 집어넣음

	printf("%s \n", str);
	return 0;
}