# include <stdio.h>
# define TEMP 10
# if TEMP > 5
# define ALPHA 5
# else
# define ALPHA 3
# endif

int main() {
	int i;
	for(i = 0; i <= ALPHA; i++)
		printf("ALPHA °ª = %d\n", i);
	return 0;
}
