#include <stdio.h>

int InterpolationSearch(int a[], int n, int key) {
	int left = 0, right = n - 1, mid;

	while (left <= right) {
		if (a[left] < a[right]) {
			mid = left + (right - left) * (key - a[left]) / (a[right] - a[left]);
		}
		else mid = left;

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

	index = InterpolationSearch(a, n, key);

	if (index >= 0) printf("%d��(��) %d��ġ���� ã��!\n", key, index);
	else printf("���� Data�Դϴ�.\n");

	return 0;
}