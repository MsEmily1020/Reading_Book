#include <iostream>

using namespace std;	// 이름 공간 (std:: 생략, 변수 등 중복 방지)

class Employee {
private:
	string name_;
	int id_;
	int age_;
	double salary_;

public:
	Employee() {}

	Employee(string name, int id, int age, int salary)
		: name_(name), id_(id), age_(age), salary_(salary) {}

	void set_name(string name) {
		name_ = name;
	}

	void set_id(int id) {
		id_ = id;
	}

	void set_age(int age) {
		age_ = age;
	}

	void set_salary(double salary) {
		salary_ = salary;
	}

	void PrintInfo() {
		cout << "이름 : " << name_ << endl;
		cout << "사번 : " << id_ << endl;
		cout << "나이 : " << age_ << endl;
		cout << "급여 : " << salary_ << endl;
		cout << endl;
	}
};

int main() {
	Employee* a = new Employee("이름1", 1206, 17, 10000);
	a->PrintInfo();
	
	Employee* b = new Employee[2];
	b[0].set_name("이름2");
	b[0].set_id(2105);
	b[0].set_age(18);
	b[0].set_salary(20000);

	b[1].set_name("이름3");
	b[1].set_id(3101);
	b[1].set_age(19);
	b[1].set_salary(30000);

	for (int i = 0; i < 2; i++) {
		b[i].PrintInfo();
	}
}