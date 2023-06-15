#include <iostream>
using namespace std;

#define COLOR_RED	0
#define COLOR_GREEN	1
#define COLOR_BLUE	2

class Animal {
public:
	Animal(int color, int age) : color_(color), age_(age)
	{
		cout << "Animal 생성자()" << endl; 
	}

	~Animal() { cout << "Animal 소멸자()" << endl; }
	void Roar(void) { cout << "Animal 짖다" << endl; }
	void Eat(void) { cout << "Animal 먹다" << endl; }
	void Sleep(void) { cout << "Animal 자다" << endl; }

private:
	int color_;
	int age_;
};

class Rabbit : public Animal {
public:
	// 부모생성자(Animal(color, age))가 먼저 호출
	Rabbit(int color, int age, int ear_length) : Animal(color, age), ear_length_(ear_length) {
		cout << "Rabbit 생성자()" << endl; 
	}
	
	~Rabbit() { cout << "Rabbit 소멸자()" << endl; }

	// 함수 override
	// 다형성(polymorphism) : 같은 함수 시그니처(반환형, 이름, 매개변수가 모두 같은)가 같은 함수임에도
	// 불구하고 다르게 실행되는 것
	void Roar(void)
	{
		cout << "깡총깡총" << endl;
	}

private:
	int ear_length_;
};

int main() {
	Rabbit* rabbit = new Rabbit(COLOR_RED, 3, 20);	// 부모 생성자 호출
	rabbit->Roar();	// 부모 멤버변수 호출
	delete rabbit;
	return 0;
}
