#include <iostream>
#include <string>

using namespace std;

// 여러 data들을 하나의 의미있는 구조체로 묶어서 관리

// 성능때문에 id, sex 문자열x -> 문자열은 정수데이터보다 상대적으로 많은 메모리 공간 요구
// 구조체, 클래스는 일반적으로 단어의 첫 글자를 대문자로
// class default 값 : private / struct default 값 : public 
class Student {
public:

	// 생성자 (constructor) : 객체 생성될 때 호출하는 함수
	// 생성자를 정의x -> default로 매개변수로 없는 생성자 정의
	Student() {
		name = "김혜승";
		id = 2105;
		age = 18;
		sex = 1;
		department = "뉴미디어소프트웨어과";
	}

	// this : 객체 자기자신을 가리키는 포인터
	// 매개변수명과 멤버면수명이 같아도 구분가능
	// 멤버변수를 초기화 하면 const 멤버변수도 초기화 가능
	Student(string _name, int _id, int _age, int _sex, string _department) 
		: name(_name), id(_id), age(_age), sex(_sex), department(_department)
	{
	}
	
	// class 멤버변수를 가질 수 있다
	void print(void) {
		cout << "이름 : " << name << endl;
		cout << "학번 : " << id << endl;
		cout << "나이 : " << age << endl;
		cout << "성별(0 : 남자, 1 : 여자) : " << sex << endl;
		cout << "학과 : " << department << endl;
	}

private:
	string name;
	// 정수 : 비교연산 한번에 가능, 문자열은 글자수만큼 반복하여 비교
	// 가독성과 유지보수를 위해 열거형(enum) 추천
	
	int id;
	int age;
	// 0 : 남자, 1 : 여자
	int sex;
	string department;

};

int main() {
	// (struct) Student 자료형
	// Student 변수명 = Student();

	Student stu1 = Student();
	stu1.print();
	cout << endl;

	// 정적할당
	Student stu2 = Student("에밀리", 1206, 17, 1, "소프트웨어과");
	stu2.print();
	cout << endl;

	//동적할당
	// TODO : 동적할당 해제하기
	Student* stu3 = new Student("MsEmily1020", 2105, 18, 1, "뉴미디어소프트웨어과");
	stu3->print();

	return 0;
}