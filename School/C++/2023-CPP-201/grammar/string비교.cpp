#include <stdio.h>
#include <string.h>

#include <iostream>
#include <string>

using namespace std;

int main() {
	string str1 = "Hello";
	string str2 = "World";

	if (str2 > str1) {
		cout << "str2 > str1" << endl;
	}
	else if (str1 > str2) {
		cout << "str1 > str2" << endl;
	}
	else {
		cout << "str1 == str2" << endl;
	}
	return 0;
}