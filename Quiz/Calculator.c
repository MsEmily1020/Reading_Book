#include <stdio.h>

int main() {
	int num1, num2, opNum;
	
	while(1) {
		printf("\t========계산기========\n\n");
		printf("\t   첫번째 숫자 : ");
		scanf("%d", &num1);
		printf("\t   두번째 숫자 : ");
		scanf("%d", &num2);
		printf("\n\t======================\n\n");
	
		printf("\t   |-----종류-----|\n");
		printf("\t   |              |\n"); 
		printf("\t   |  1. 더하기   |\n");
		printf("\t   |  2. 빼기     |\n");
		printf("\t   |  3. 곱하기   |\n");
		printf("\t   |  4. 나누기   |\n");	
		printf("\t   |  5. 나머지   |\n");	
		printf("\t   |  6. 종료     |\n");	
		printf("\t   |              |\n"); 
		printf("\t   |--------------|\n\n");
	
		printf("\t    번호 선택 : ");
		scanf("%d", &opNum);
		
		if (opNum == 6) break;
		
		printf("\t    ");
		switch(opNum) {
			case 1 : printf("%d + %d ==> %d\n", num1, num2, (num1 + num2)); break;
			case 2 : printf("%d - %d ==> %d\n", num1, num2, (num1 - num2)); break;
			case 3 : printf("%d * %d ==> %d\n", num1, num2, (num1 * num2)); break;
			case 4 : printf("%d / %d ==> %f\n", num1, num2, (float)(num1 / num2)); break;
			case 5 : printf("%d %c %d ==> %d\n", num1, '%', num2, (num1 % num2)); break;
			default : printf("잘못 눌렀어요."); break;
		}
		
		printf("\n\n"); 
	}
	
	printf("\n\t계산기 프로그램을 종료합니다.\n");
	return 0;
}
