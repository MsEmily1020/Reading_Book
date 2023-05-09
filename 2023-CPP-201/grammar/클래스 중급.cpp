#include <iostream>
#include <string>
#include <string.h>

using namespace std;

class MString {
public:
	// 생성자(constructor) : 객체가 생성(메모리에 할당될 때)될 때 호출되는 함수
	// 클래스이름과 같다, 반환형이 없다
	MString(const char* str)
	{
		size_ = strlen(str);
		// 필요한 길이만큼 문자열 동적할당
		c_str_ = new char[size_ + 1];	// + 1 : null 공간
		strcpy(c_str_, str);
		cout << "MString 생성자 호출 완료" << endl;
	}

	// 소멸자(dextructor) : 객체가 소멸(메모리에 해제될 때)될 때 호출되는 함수
	// ~클래스이름, 반환형과 매개변수 없다
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
	MString str1 = MString("Aitai");
	cout << str1.c_str() << endl;

	return 0;
}