# include <stdio.h>
# define TEMP 1
# if TEMP
# define ALPHA 100
# else
# define ALPHA 200
# endif

int main() {
	int a = ALPHA;
	printf("ALPHA value = %d\n", a);
	return 0;
}
