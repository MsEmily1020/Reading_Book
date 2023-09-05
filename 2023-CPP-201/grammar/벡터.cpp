#include <iostream>
#include <vector>

using namespace std;

int main(void) {

	vector<int> arr;
	arr.reserve(4); // 벡터의 크기를 4로 지정
	arr[0] = 10, arr[1] = 20, arr[2] = 30, arr[3] = 40;

	// 4개가 꽉 찬 공간에 데이터 하나를 더 집어넣어보기
	arr.push_back(50);

	for (int i = 0; i < 5; i++)
		cout << arr[i] << " ";
}