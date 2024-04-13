#include <iostream>
#include <string> // std::string 들어있음(.h x)

using namespace std;

int main() {
	string str1;
	string str2 = "c_insert";

	str1 = str2;

	cout << str1 << endl;
	return 0;
}