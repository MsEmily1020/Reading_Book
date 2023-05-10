#include <stdio.h>

int main() {
	float L = 0, S = 0;
	int K = 0, SW = 0;
	
	do {
		K++;
		L = (double)K / ((K+1) * (K+2));
		if(SW == 0) {
			S += L;
			SW = 1;	
		}
		
		else {
			S -= L;
			SW = 0;
		}
	} while(K != 49);
	
	printf("%f\n", S);
	return 0;
} 
