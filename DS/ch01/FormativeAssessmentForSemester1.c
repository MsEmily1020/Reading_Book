#include <stdio.h>

int main() {
	int a[10] = { 3, 6, 9, 12, 15 };
	int* ptr;

	printf("��� ���\n");
	ptr = a;
	printf("��. %d, %d\n", *ptr, *(ptr + 4));

	ptr += 3;
	printf("��. %d, %d, %d, %d\n", a[1], *(a + 2), ptr[0], ptr[2]);
	return 0;
}