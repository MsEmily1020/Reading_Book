#include <stdio.h>

int main() {
	double d;	//+- 1.7*10(-308) ~ +- 1.7*10(308)
	scanf("%lf", &d);
	printf("%.11lf", d); 
	return 0;
}
