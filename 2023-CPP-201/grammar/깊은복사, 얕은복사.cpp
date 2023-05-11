#include <iostream>

using namespace std;

int main(void)
{
	// ptr1은 int 3개의 배열을 동적할당 시킨 후 가리킨다
	int* ptr1 = new int[3];
	ptr1[0] = 0, ptr1[1] = 10, ptr1[2] = 20;

	// 깊은 복사(deep copy) : ptr2는 별도의 공간을 동적할당 후 ptr1의 값 복사
	int* ptr2 = new int[3];
	for (int i = 0; i < 3; i++)
	{
		ptr2[i] = ptr1[i];
	}

	// 깊은 복사를 하면 고유의 공간을 가지므로 ptr2[1]은 100으로 바뀌지 않음
	ptr1[1] = 100;
	for (int i = 0; i < 3; i++) 
	{
		cout << ptr1[i] << " " << ptr2[i] << endl;
	}

	// 얕은 복사 : delete[] ptr1만 해도 ptr2의 데이터 같이 없어지는 것
	// 깊은 복사 : 둘의 공간이 다르므로 따로 따로 삭제 가능
	delete[] ptr1;
	delete[] ptr2;
	return 0;
}