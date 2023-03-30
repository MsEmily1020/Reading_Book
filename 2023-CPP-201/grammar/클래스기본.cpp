#include <iostream>
#include <string>

using namespace std;

// 여러 data들을 하나의 의미있는 구조체로 묶어서 관리

// 성능때문에 id, sex 문자열x -> 문자열은 정수데이터보다 상대적으로 많은 메모리 공간 요구
// 구조체, 클래스는 일반적으로 단어의 첫 글자를 대문자로
// class default 값 : private / struct default 값 : public 
class Student {
public:
	string name;
	// 정수 : 비교연산 한번에 가능, 문자열은 글자수만큼 반복하여 비교
	// 가독성과 유지보수를 위해 열거형(enum) 추천
	int id;
	int age;
	// 0 : 남자, 1 : 여자
	int sex;
	string department;

	// class 멤버변수를 가질 수 있다
	void print(void) {
		cout << "이름 : " << name << endl;
		cout << "학번 : " << id << endl;
		cout << "나이 : " << age << endl;
		cout << "성별(0 : 남자, 1 : 여자) : " << sex << endl;
		cout << "학과 : " << department << endl;
	}
};

int main() {
	// (struct) Student 자료형
	struct Student student1;
	student1.name = "김혜승";
	student1.id = 2105;
	student1.age = 18;
	student1.sex = 1;
	student1.department = "뉴미디어 소프트웨어과";

	student1.print();
	return 0;
}