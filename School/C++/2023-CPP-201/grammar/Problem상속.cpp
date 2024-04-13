#include <iostream>

using namespace std;

class Person {
private:
	string name;
	int hakbun;

public:
	Person(string name_, int hakbun_) :
		name(name_), hakbun(hakbun_) {
		cout << "Person ������ ȣ��" << endl;
	}
	
	~Person() { cout << "Person �Ҹ���()" << endl; }

	void PrintShow(void) {
		cout << "�̸� : " << name << endl;
		cout << "�й� : " << hakbun << endl;
	}
};

class Student : public Person {
private:
	string university;

public:
	Student(string name_, int hakbun_, string university_)
		: Person(name_, hakbun_), university(university_) {
		cout << "Student ������ ȣ��" << endl;
		cout << "�б� : " << university << endl;
	}

	~Student() { cout << "Student �Ҹ���()" << endl; }

};

int main() {
	Student* stu = new Student("������", 2105, "�̸������������а���б�");
	stu->PrintShow();
	delete stu;
	return 0;
}