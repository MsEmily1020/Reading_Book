#include <iostream>
using namespace std;

#define COLOR_RED	0
#define COLOR_GREEN	1
#define COLOR_BLUE	2

class Animal {
public:
	Animal(int color, int age) : color_(color), age_(age)
	{
		cout << "Animal ������()" << endl; 
	}

	virtual ~Animal() { cout << "Animal �Ҹ���()" << endl; }
	// ���� �����Լ� : JAVAó�� �������ε� + �߻�޼���ó�� �Լ� ���� x -> ��ӹ��� �ڽĿ��� ����
	virtual void Roar(void) = 0;
	virtual void Eat(void) = 0;
	virtual void Sleep(void) = 0;

private:
	int color_;
	int age_;
};

class Rabbit : public Animal {
public:
	// �θ������(Animal(color, age))�� ���� ȣ��
	Rabbit(int color, int age, int ear_length) : Animal(color, age), ear_length_(ear_length) {
		cout << "Rabbit ������()" << endl; 
	}
	
	virtual ~Rabbit() { cout << "Rabbit �Ҹ���()" << endl; }

	// �Լ� override
	// ������(polymorphism) : ���� �Լ� �ñ״�ó(��ȯ��, �̸�, �Ű������� ��� ����)�� ���� �Լ��ӿ���
	// �ұ��ϰ� �ٸ��� ����Ǵ� ��
	// override : �θ� �Լ� �ñ״�ó�� �������� ������ �����߻�(�Ǽ� ����)
	void Roar(void) override 
	{
		cout << "���ѱ���" << endl;
	}

	// ���������Լ�(�߻�޼���)�� �ڽ� Ŭ�������� ������ �����ؾ� ��
	void Eat(void) override {}
	void Sleep(void) override {}

private:
	int ear_length_;
};

int main() {
	// AnimalŬ������ ���������Լ��� �ϳ��� �����ϴ� Ŭ���� = �߻�Ŭ������
	// Animal* a = new Animal(COLOR_GREEN, 10); -> �߻�Ŭ�����̹Ƿ� �ش� ��ü ���� x
	Animal* animal = new Rabbit(COLOR_RED, 3, 20);
	animal->Roar();	// ���ѱ���
	delete animal;
	return 0;
}
