#include <iostream>

using namespace std;

class Person {
private:
	string name;
	int hakbun;

public:
	Person(string name_, int hakbun_) :
		name(name_), hakbun(hakbun_) {
		cout << "Person 생성자 호출" << endl;
	}
	
	~Person() { cout << "Person 소멸자()" << endl; }

	void PrintShow(void) {
		cout << "이름 : " << name << endl;
		cout << "학번 : " << hakbun << endl;
	}
};

class Student : public Person {
private:
	string university;

public:
	Student(string name_, int hakbun_, string university_)
		: Person(name_, hakbun_), university(university_) {
		cout << "Student 생성자 호출" << endl;
		cout << "학교 : " << university << endl;
	}

	~Student() { cout << "Student 소멸자()" << endl; }

};

int main() {
	Student* stu = new Student("김혜승", 2105, "미림여자정보과학고등학교");
	stu->PrintShow();
	delete stu;
	return 0;
}