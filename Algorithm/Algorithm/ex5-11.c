#include <stdio.h>

int main() {
	int num;
	printf("������ �Է� : ");
	scanf("%d", &num);
	
	if(num % 2 == 0 && num % 3 == 0) printf("2�� 3�� ���");
	else if (num % 2 == 0) printf("2�� ���");
	else if (num % 3 == 0) printf("3�� ���"); 
	else printf("2�� 3�� ����� �ƴ�");
	return 0;
}
