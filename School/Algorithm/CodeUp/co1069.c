#include <stdio.h>

int main() {
	char ch;
	scanf("%c", &ch);
	
	switch(ch) {
  	case 'A':
  		printf("best!!!");
    	break;
    	
  	case 'B':
  		printf("good!!");
    	break;
    	
  	case 'C':
  		printf("run!");
    	break;
    	
    case 'D':
    	printf("slowly~");
    	break;
    	
  	default:
  		printf("what?");
  	}
  	
	return 0;
}
