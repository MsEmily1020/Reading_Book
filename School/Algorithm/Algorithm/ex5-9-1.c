#include <stdio.h>

int main() {
	int score;
	printf("점수 입력 = ");
	scanf("%d", &score);
	
	if (score < 0 || score > 100) printf("오류\n");
	else if (score >= 70 && score <= 100) printf("성공\n");
	else printf("실패\n");
	return 0;
}
