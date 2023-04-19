#include <stdio.h>

int main() {
	float a, b, c, tmp;
	printf("실수 3개를 입력하시오 : ");
	scanf("%f %f %f", &a, &b, &c);
	
	if (a > b) {
		tmp = a;
		a = b;
		b = tmp;
	}
	
	if (a > c) {
		tmp = a;
		a = c;
		c = tmp; 
	}
	
	if (b > c) {
		tmp = b;
		b = c;
		c = tmp;
	}
	
	printf("%f %f %f\n", a, b, c);
	return 0;
}
