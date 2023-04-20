#include <iostream>
#include <string>
#include <string.h>

using namespace std;

class MString {
public:
	// 생성자
	MString(const char* str)
	{
		size_ = strlen(str);
		// 필요한 길이만큼 문자열 동적할당
		c_str_ = new char[size_ + 1];	// + 1 : null 공간
		strcpy(c_str_, str);
	}

	// getter
	unsigned int size() { return size_; }
	char* c_str() { return c_str_; }

private:
	unsigned int size_;		// 문자열의 길이
	char* c_str_;			// 문자열을 가리키는 주소
};

int main(void)
{
	const int len = 1000000;
	MString* str = new MString("Aitai 2-1");
	
	cout << str->c_str() << endl;
	delete str;
	return 0;
}