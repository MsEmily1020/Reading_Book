#include <stdio.h>

int main() {
	int a, b, c;
	printf("���� 3���� �Է��Ͻÿ�: ");
	scanf("%d %d %d", &a, &b, &c);

	if((a >= 0 && a <= 100) && (b >= 0 && b <= 100) && (c >= 0 && c <= 100))
		printf("average = %.2f", (float)(a + b + c) / 3);
	else
		printf("���� : �߸��� �����Դϴ�.");
	return 0;
} 
