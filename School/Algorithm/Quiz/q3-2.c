#include <stdio.h>

int main() {
	double r = 3, a = 2, s = a, n = 2;
	while(1) {
		a *= r;
		s += a;
		n++;
		if(n > 100) break;
	}
	
	printf("%lf\n", s);
	return 0;
}
