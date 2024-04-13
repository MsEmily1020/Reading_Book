#include <stdio.h>

void SelectionSort(int a[], int n) {
	int i, j, key;

	for (i = 1; i < n; i++) {
		key = a[i];
		
		for (j = i - 1; j >= 0; j--) {
			if (key < a[j]) a[j + 1] = a[j];
			else break;
		}

		a[j + 1] = key;
	}
}

int main(void) {
	int a[] = { 10, 5, 7, 12, 9, 16, 1, 3, 2, 17 };
	int i, n = sizeof(a) / sizeof(int);
	
	printf("정렬 전 : ");
	for (i = 0; i < n; i++) printf("%d ", a[i]);
	
	SelectionSort(a, n);
	
	printf("\n선택 정렬 후 : ");
	for (i = 0; i < n; i++) printf("%d ", a[i]);
	
	return 0;
}