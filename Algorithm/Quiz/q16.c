#include <stdio.h>

int main() {
	int n, i = 1;
	printf("구구단 중에서 출력하고 싶은단을 입력하시오: ");
	scanf("%d", &n);
	while(i <= 9) {
		printf("%d * %d = %d\n", n, i, n * i);
		i++;
	}
	return 0;
}
