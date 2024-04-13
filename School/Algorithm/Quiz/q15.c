#include <stdio.h>

int main() {
	double T[10] = { 184, 240, 9, 210, 20, 38, 100, 200, 282, 100 };
	int N = 0, i = 0, sum = 0;
	
	while(i++ < 30) {
		if(T[i] > 200) {
			sum += T[i];
			N++;	
		}
	}
	
	printf("ЦђБе = %.1lf\n", (double)(sum / N));
	return 0;
}
