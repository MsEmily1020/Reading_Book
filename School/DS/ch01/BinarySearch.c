#include <stdio.h>

int binarySearch(int a[], int n, int key) {
	int left = 0, right = n - 1, mid;

	while (left <= right) {
		mid = (left + right) / 2;
		if (key == a[mid]) return mid;
		else if (key > a[mid]) left = mid + 1;
		else right = mid - 1;
	}

	return -1;
}

int main(void) {
	int a[] = { 3, 4, 5, 6, 7, 8, 9, 10 };
	int n = sizeof(a) / sizeof(int);
	int index, key;

	printf("ã�� ��: ");
	scanf_s("%d", &key);

	index = binarySearch(a, n, key);

	if (index >= 0) printf("%d��(��) %d��ġ���� ã��!\n", key, index);
	else printf("���� Data�Դϴ�.\n");

	return 0;
}