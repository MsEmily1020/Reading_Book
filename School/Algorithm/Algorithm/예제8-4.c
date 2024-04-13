#include <stdio.h>

int main(){
   char ch;
   char *p = &ch;
   printf("문자 1자 입력: ");
   scanf("%c", &ch);
   printf("%c %d %c %d %d\n",*p, p, ch, ch, &ch);
   
   return 0;
}
