#include <stdio.h>
// #define string_job(A, B) "A�� ������ B�Դϴ�."
#define string_job(A, B) #A "�� ������ " #B "�Դϴ�."
int main() {
	printf("%s", string_job(ȫ�浿, �丮��));
	return 0;
}

