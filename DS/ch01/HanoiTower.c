#include <stdio.h>

//a : 출발지, b : 경유지, c : 도착지
void HanoiTower(int n, char a, char b, char c) {
	if (n == 1) printf("원판 %d, %c -> %c\n", n, a, c); //1번 이동
	else {
		HanoiTower(n - 1, a, c, b); // (n - 1)개 출발지 -> 경유지
		printf("원판 %d, %c -> %c\n", n, a, c); //n번 원판 이동
		HanoiTower(n - 1, b, a, c); // (n - 1)개 경유지 -> 도착지
	}
}
int main() {
	int n = 4;
	HanoiTower(n, 'A', 'B', 'C');
	return 0;
}