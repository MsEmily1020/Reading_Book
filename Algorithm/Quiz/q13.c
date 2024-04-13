#include <stdio.h>

int main() {
	int score[] = {100, 30, 40, 50, 10, 90, 60, 0, 91, 100};
	int cnt = 0;
	int i = 0;
	while(i < 10) {
		if(score[i] >= 80) cnt++;
		i++;
	}
	
	printf("%d", cnt);
	return 0;
}
