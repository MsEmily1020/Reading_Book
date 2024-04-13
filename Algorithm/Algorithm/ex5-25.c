#include <stdio.h>
// #define string_job(A, B) "A의 직업은 B입니다."
#define string_job(A, B) #A "의 직업은 " #B "입니다."
int main() {
	printf("%s", string_job(홍길동, 요리사));
	return 0;
}

