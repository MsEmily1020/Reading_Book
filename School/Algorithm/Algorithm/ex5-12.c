#include <stdio.h>

int main() {
	int a, b, c;
	printf("점수 3개를 입력하시오: ");
	scanf("%d %d %d", &a, &b, &c);

	if((a >= 0 && a <= 100) && (b >= 0 && b <= 100) && (c >= 0 && c <= 100))
		printf("average = %.2f", (float)(a + b + c) / 3);
	else
		printf("오류 : 잘못된 점수입니다.");
	return 0;
} 
