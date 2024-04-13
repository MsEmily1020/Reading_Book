#include <iostream>
#include <string>

using namespace std;

// ���� data���� �ϳ��� �ǹ��ִ� ����ü�� ��� ����

// ���ɶ����� id, sex ���ڿ�x -> ���ڿ��� ���������ͺ��� ��������� ���� �޸� ���� �䱸
// ����ü, Ŭ������ �Ϲ������� �ܾ��� ù ���ڸ� �빮�ڷ�
// class default �� : private / struct default �� : public 
class Student {
public:

	// ������ (constructor) : ��ü ������ �� ȣ���ϴ� �Լ�
	// �����ڸ� ����x -> default�� �Ű������� ���� ������ ����
	// �����ڴ� ��ȯ���� ���� �ʤ��´�
	// �������Լ��� �̸��� Ŭ������� ����
	Student() {}

	// this : ��ü �ڱ��ڽ��� ����Ű�� ������
	// �Ű�������� ���������� ���Ƶ� ���а���
	// ��������� �ʱ�ȭ �ϸ� const ��������� �ʱ�ȭ ����
	Student(string _name, int _id, int _age, int _sex, string _department) 
		: name(_name), id(_id), age(_age), sex(_sex), department(_department)
	{
	}
	
	// class ��������� ���� �� �ִ�
	void print(void) {
		cout << "�̸� : " << name << endl;
		cout << "�й� : " << id << endl;
		cout << "���� : " << age << endl;
		cout << "����(0 : ����, 1 : ����) : " << sex << endl;
		cout << "�а� : " << department << endl;
	}

	void set_name(string _name) { this->name = _name; }
	void set_id(int _id) { this->id = _id; }
	void set_age(int _age) { this->age = _age; }
	void set_sex(int _sex) { this->sex = _sex; }
	void set_department(string _department) { this->department = _department; }

private:
	string name;
	// ���� : �񱳿��� �ѹ��� ����, ���ڿ��� ���ڼ���ŭ �ݺ��Ͽ� ��
	// �������� ���������� ���� ������(enum) ��õ
	
	int id;
	int age;
	// 0 : ����, 1 : ����
	int sex;
	string department;

};

int main() {
	// (struct) Student �ڷ���
	// Student ������ = Student();

	Student stu1 = Student();
	stu1.print();
	cout << endl;

	// �����Ҵ� : �޸��� ũ�Ⱑ �������� �� ������.
	Student stu2 = Student("���и�", 1206, 17, 1, "����Ʈ�����");
	stu2.print();
	cout << endl;

	//�����Ҵ� : �޸��� ũ�Ⱑ ������ ��(runtime) ������. heap����
	// C++�� �����Ҵ��� �ݵ�� delete�� �����ؾ� �޸� ������ ���� �� ����
	// TODO : �����Ҵ� �����ϱ�
	Student* stu3 = new Student("MsEmily1020", 2105, 18, 1, "���̵�����Ʈ�����");
	stu3->print();	// ���� ��ü�� ����� ->�� ����

	delete stu3;

	cout << endl;

	Student stu4[2];
	for (int i = 0; i < sizeof(stu4) / sizeof(stu4[0]); i++) {
		stu4[i].print();
		cout << endl;
	}

	Student* stu5 = new Student[2];
	for (int i = 0; i < 2; i++) {
		stu5[i].print();	// �迭�� ��ҿ� �ش��ϴ� ��ü�� ����� .���� ����
		cout << endl;
	}

	delete[] stu5;

	Student* stu6 = new Student[2];
	stu6[0].set_age(18);
	stu6[0].set_name("����");
	stu6[0].set_id(2112);
	stu6[0].set_sex(1);
	stu6[0].set_department("���̵�����Ʈ�����");

	stu6[1].set_age(18);
	stu6[1].set_name("����");
	stu6[1].set_id(2118);
	stu6[1].set_sex(0);
	stu6[1].set_department("���̵�����Ʈ����");

	for (int i = 0; i < 2; i++) {
		stu6[i].print();
		cout << endl;
	}

	return 0;
}