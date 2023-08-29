#include <iostream>
#include "Animal.h"
#include "Shark.h"
#include "Whale.h"

using namespace std;

int main(void) {
	Animal a;
	Shark jaws;
	Whale lky;

	a.sing();
	jaws.sing();
	lky.sing();
}