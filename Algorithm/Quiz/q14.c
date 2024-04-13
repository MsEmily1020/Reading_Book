#include <stdio.h>

int main() {
	int math[] = {80, 30, 10, 100, 30, 90, 100, 93, 0, 2};
	int eng[] = {100, 30, 40, 50, 100, 10, 100, 100, 90, 10};
	
	int i = 0;
	int max = 0;
	int e = 0;
	while(i < 10) {
		if(eng[i] == 100 && math[i] > max)  {
			e = eng[i];
			max = math[i];
		}
		i++;
	}	
	
	printf("영어점수 = %d, 수학점수 = %d", e, max);
	return 0;
}
