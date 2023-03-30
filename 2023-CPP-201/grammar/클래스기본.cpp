#include <iostream>
#include <string>

using namespace std;

// 여러 data들을 하나의 의미있는 구조체로 묶어서 관리
struct drink {
	string company;
	string adding;
};

int main() {
	// (struct) drink 자료형
	struct drink strawberryMilk;
	strawberryMilk.company = "서울우유";
	strawberryMilk.adding = "킹스베리";

	cout << "회사 이름 : " << strawberryMilk.company << "\n첨가물 : " << strawberryMilk.adding << endl;
	return 0;
}