#include <stdio.h>

int main() {
	int score;
	printf("점수 입력 = ");
	scanf("%d", &score);
	
	if (score >= 70 && score <= 100) printf("성공\n");
	else if (score >= 0 && score < 70) printf("실패\n");
	else printf("오류\n");
	return 0;
}
