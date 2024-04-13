#include <stdio.h>
#include <stdlib.h>
#define SIZE 1000000

int main() {
	int *a = (int *)malloc(sizeof(int)*SIZE); // 배열 a는 4Mb 크기 요구
	a[0] = 10;

	// 출력 x
	// 해결방법 1. 스택 예약 크기를 5000000으로 바꾸기
	//			2. 배열을 포인터로 바꾸고 동적할당 (malloc)
	printf("%d\n", a[0]);
	return 0;
}