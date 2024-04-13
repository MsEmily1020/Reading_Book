# include <stdio.h>
# if TEMP > 5
# define ALPHA 5
# else
# define ALPHA 3
# endif

int main() {
	int a, TEMP = 10;
	for(a = 0; a <= ALPHA; a++)
		printf("ALPHA = %d, value a = %d\n", ALPHA, a);
	return 0;
}
