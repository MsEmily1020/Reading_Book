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
		cout << "MString 생성자 호출 완료" << endl;
	}

	// 소멸자(dextructor)
	~MString()
	{
		// 생성자에서 동적할당한 공간 해제
		delete[] c_str_;
		cout << "MString 소멸자 호출 완료" << endl;
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
	// new로 동적할당한 공간은 반드시 delete로 해제 (안하면 메모리 누수)
	MString* str = new MString("Aitai 2-1");

	cout << str->c_str() << endl;

	// str은 delete됨, str->c_str_은 delete 진행x
	// TODO : 이름 delete 해주는 소멸(destructor) 구현
	delete str;
	return 0;
}