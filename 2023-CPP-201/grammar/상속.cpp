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

	virtual ~Animal() { cout << "Animal 소멸자()" << endl; }
	// 순수 가상함수 : JAVA처럼 동적바인딩 + 추상메서드처럼 함수 정의 x -> 상속받은 자식에서 정의
	virtual void Roar(void) = 0;
	virtual void Eat(void) = 0;
	virtual void Sleep(void) = 0;

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
	
	virtual ~Rabbit() { cout << "Rabbit 소멸자()" << endl; }

	// 함수 override
	// 다형성(polymorphism) : 같은 함수 시그니처(반환형, 이름, 매개변수가 모두 같은)가 같은 함수임에도
	// 불구하고 다르게 실행되는 것
	// override : 부모 함수 시그니처가 존재하지 않으면 에러발생(실수 방지)
	void Roar(void) override 
	{
		cout << "깡총깡총" << endl;
	}

	// 순수가상함수(추상메서드)는 자식 클래스에서 무조건 정의해야 함
	void Eat(void) override {}
	void Sleep(void) override {}

private:
	int ear_length_;
};

int main() {
	// Animal클래스는 순수가상함수가 하나라도 존재하는 클래스 = 추상클래스임
	// Animal* a = new Animal(COLOR_GREEN, 10); -> 추상클래스이므로 해당 객체 생성 x
	Animal* animal = new Rabbit(COLOR_RED, 3, 20);
	animal->Roar();	// 깡총깡총
	delete animal;
	return 0;
}
