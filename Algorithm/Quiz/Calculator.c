#include <stdio.h>

int main() {
	int num1, num2, opNum;
	
	while(1) {
		printf("\t========����========\n\n");
		printf("\t   ù��° ���� : ");
		scanf("%d", &num1);
		printf("\t   �ι�° ���� : ");
		scanf("%d", &num2);
		printf("\n\t======================\n\n");
	
		printf("\t   |-----����-----|\n");
		printf("\t   |              |\n"); 
		printf("\t   |  1. ���ϱ�   |\n");
		printf("\t   |  2. ����     |\n");
		printf("\t   |  3. ���ϱ�   |\n");
		printf("\t   |  4. ������   |\n");	
		printf("\t   |  5. ������   |\n");	
		printf("\t   |  6. ����     |\n");	
		printf("\t   |              |\n"); 
		printf("\t   |--------------|\n\n");
	
		printf("\t    ��ȣ ���� : ");
		scanf("%d", &opNum);
		
		if (opNum == 6) break;
		
		printf("\t    ");
		switch(opNum) {
			case 1 : printf("%d + %d ==> %d\n", num1, num2, (num1 + num2)); break;
			case 2 : printf("%d - %d ==> %d\n", num1, num2, (num1 - num2)); break;
			case 3 : printf("%d * %d ==> %d\n", num1, num2, (num1 * num2)); break;
			case 4 : printf("%d / %d ==> %f\n", num1, num2, (float)(num1 / num2)); break;
			case 5 : printf("%d %c %d ==> %d\n", num1, '%', num2, (num1 % num2)); break;
			default : printf("�߸� �������."); break;
		}
		
		printf("\n\n"); 
	}
	
	printf("\n\t���� ���α׷��� �����մϴ�.\n");
	return 0;
}
