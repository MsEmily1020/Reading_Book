#include <iostream>

using namespace std;	// �̸� ���� (std:: ����, ���� �� �ߺ� ����)

// �Լ� �����ε� : �Լ� �̸� ����
// �Լ��� �̸��� ����, but �Ű����� �ٸ�

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