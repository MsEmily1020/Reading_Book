#include <iostream>
#include <string.h>

using namespace std;

class Character {
public :
	// 일반 생성자(깊은복사)
	Character(const char* str)
	{
		// 3("abc") + 1('\0')
		str_ = new char[strlen(str) + 1];
		strcpy(str_, str);	// str의 내용을 str_에 복사
		cout << "일반생성자 호출" << endl;
	}

	// 복사 생성자(얕은 복사로 인하여 문제점 발생)
	Character(const Character& m)
	{
		str_ = new char[strlen(m.str_) + 1];
		strcpy(str_,m.str_);	// str의 내용을 str_에 복사
		cout << "복사생성자 호출" << endl;
	}

	// 소멸자
	~Character()
	{
		delete[] str_;
		cout << "소멸자 호출" << endl;
	}
private :
	char* str_;
};

int main(void)
{
	Character ch1 = Character("abc");	// 일반생성자 호출
	Character ch2 = ch1;				// 복사생성자 호출
}