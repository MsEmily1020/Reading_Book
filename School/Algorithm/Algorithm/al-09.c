#include <stdio.h>

int main() {
	int L = 0, K = 0, S = 0, SW = 0;
	do {
		K++;
		L = K / ((K+1) * (K+2));
		if(SW == 0) {
			S += L;
			SW = 1;	
		}
		
		else {
			S -= L;
			SW = 0;
		}
		
	} while(K != 49);
	
	printf("%d %d", S, L);
	return 0;
} 
