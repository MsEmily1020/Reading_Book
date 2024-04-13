#include <iostream>
#include <string>

using namespace std;

int main() {
	string str = "Jiwoo";
	// length()도 가능, but size()가 더 괜찮음
	cout << "문자열의 길이는 " << str.size() << endl;
	return 0;
}