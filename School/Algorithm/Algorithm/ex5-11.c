#include <stdio.h>

int main() {
	int num;
	printf("정수값 입력 : ");
	scanf("%d", &num);
	
	if(num % 2 == 0 && num % 3 == 0) printf("2와 3의 배수");
	else if (num % 2 == 0) printf("2의 배수");
	else if (num % 3 == 0) printf("3의 배수"); 
	else printf("2와 3의 배수가 아님");
	return 0;
}
