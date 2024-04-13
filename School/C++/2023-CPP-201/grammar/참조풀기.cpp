#include <iostream>

using namespace std;	// 이름 공간 (std:: 생략, 변수 등 중복 방지)

void plus2(int& num) {
	num += 2;
}

int main() {
	int a = 3;
	plus2(a);
	cout << a << endl;

	return 0;
}