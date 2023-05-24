#include <stdio.h>
#define PI 3.141592

int main() {
	double degree;
	double rad;
	printf("입력할 각도는 : ");
	scanf("%lf", &degree);
	rad = (PI * degree) / 180.0;
	printf("\n%.2lf rads\n", rad);
	return 0;
}

