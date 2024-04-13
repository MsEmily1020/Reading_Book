#include <iostream>
#include <string>
#include <string.h>

using namespace std;

class MString {
public:
	// �Ϲ����� ������
	// ������(constructor) : ��ü�� ����(�޸𸮿� �Ҵ�� ��)�� �� ȣ��Ǵ� �Լ�
	// Ŭ�����̸��� ����, ��ȯ���� ����
	MString(const char* str)
	{
		unsigned int str_length = strlen(str);
		// �ʿ��� ���̸�ŭ ���ڿ� �����Ҵ�
		c_str_ = new char[str_length + 1];	// + 1 : null ����
		strcpy(c_str_, str);
		cout << "MString ������ ȣ�� �Ϸ�" << endl;
	}

	// ���������(������ �������� ������ �����Ϸ��� �Ʒ��� ���� ��������ڸ� ����� ��)
	// TODO : ����� ��ü�� �Ҹ�� �� �߻��ϴ� ������ �ذ��ϱ�
	MString(const MString& rhs) 
		: size_(rhs.size_), c_str_(rhs.c_str_)
	{
		cout << "��������� ȣ��" << endl;
	}

	// �Ҹ���(dextructor) : ��ü�� �Ҹ�(�޸𸮿� ������ ��)�� �� ȣ��Ǵ� �Լ�
	// ~Ŭ�����̸�, ��ȯ���� �Ű����� ����
	~MString()
	{
		// �����ڿ��� �����Ҵ��� ���� ����
		delete[] c_str_;
		cout << "MString �Ҹ��� ȣ�� �Ϸ�" << endl;
	}

	// getter
	unsigned int size() { return size_; }
	char* c_str() { return c_str_; }

private:
	unsigned int size_;		// ���ڿ��� ����
	char* c_str_;			// ���ڿ��� ����Ű�� �ּ�
};

int main(void)
{
	// �Ϲ����� ������ ȣ��
	MString str1 = MString("Aitai");

	// ��������� ȣ��
	MString str2 = str1;

	return 0;
}