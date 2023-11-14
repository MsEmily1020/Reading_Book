#include <iostream>
#include <string>

using namespace std;

class Champ {
public:
	// 함수의 선언
	Champ(const string& name);
	// static 멤버함수에는 일반 멤버변수가 들어갈 수 없다.
	// static 멤버함수는 객체 생성 없이도 호출되어야 하나
	static int get_cnt() {
		// non_static = 1; 이 변수는 무조건 객체가 생성되어야 함.
		return cnt_;
	}

private:
	int non_static;
	static int cnt_;
};

// 함수를 바깥에서 정의할 때는 멤버함수나 멤버변수 이름 앞에 클리스 이름::
Champ::Champ(const string& name) {
	++cnt_;
}

// static 멤버변수는 무조건 바깥에서 정의하기 (const 제외)
int Champ::cnt_ = 0;

int main(void)
{
	Champ* a = new Champ("hello");
	Champ* b = new Champ("world");
	// Champ::cnt_의 값은 2
	// cnt_변수는 모두가 공유하기 때문에 1개만 있음
	// Champ형 객체는 2개 있음

	// 객체를 생성하지 않아도 static 멤버함수를 호출 할 수 있음
	cout << Champ::get_cnt() << endl;
	cout << a->get_cnt() << endl;
	cout << b->get_cnt() << endl;

}