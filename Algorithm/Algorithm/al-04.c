#include <stdio.h>

int main() {
	int i = 1, odd = 0, even = 0;
	for(; i <= 100; i++) {
		if(i % 2 == 0) even += i;
		else odd += i;
	}
	printf("Ȧ���� �� : %d, ¦���� �� : %d\n", odd, even);
	return 0;
}
