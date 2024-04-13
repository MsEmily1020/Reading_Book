#include <iostream>

using namespace std;

template <typename T>
T sum(T x, T y)
{
	T z = x + y;
	return z;
}

int main() {
	cout << sum<int>(1, 2) << endl;
	cout << sum<double>(1.1, 2.1) << endl;
	return 0;
}