#include <stdio.h>
#include <stdlib.h>
#define SIZE 1000000

int main() {
	int *a = (int *)malloc(sizeof(int)*SIZE); // �迭 a�� 4Mb ũ�� �䱸
	a[0] = 10;

	// ��� x
	// �ذ��� 1. ���� ���� ũ�⸦ 5000000���� �ٲٱ�
	//			2. �迭�� �����ͷ� �ٲٰ� �����Ҵ� (malloc)
	printf("%d\n", a[0]);
	return 0;
}