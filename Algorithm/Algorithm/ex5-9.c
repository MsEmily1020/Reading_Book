#include <stdio.h>

int main() {
	int score;
	printf("���� �Է� = ");
	scanf("%d", &score);
	
	if (score >= 70 && score <= 100) printf("����\n");
	else if (score >= 0 && score < 70) printf("����\n");
	else printf("����\n");
	return 0;
}
