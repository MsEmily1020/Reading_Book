#include <iostream>

using namespace std;	// 이름 공간 (std:: 생략, 변수 등 중복 방지)

// 함수 오버로딩 : 함수 이름 간략
// 함수의 이름은 같음, but 매개변수 다름

int sum(int a, int b) {
	return a + b;
}

float sum(float a, float b) {
	return a + b;
}

int main() {
	cout << sum(1, 2) << endl;
	cout << sum(1.1f, 2.1f) << endl;

	return 0;
}