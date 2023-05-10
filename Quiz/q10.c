#include <stdio.h>

int main() {
	int a, b;
	scanf("%d %d", &a, &b);
	if(a >= 60 && b >= 60)
		printf("합격\n참 잘했어요");
	else 
		printf("불합격\n조금 더 노력해주세요");
	return 0;
}
