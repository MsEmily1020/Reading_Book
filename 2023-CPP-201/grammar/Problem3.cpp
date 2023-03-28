#include <iostream>
#include <string>

using namespace std;

int main() {
    string str1 = "Hello";
    string str2 = ", world!";
    str1 = str1 + str2;
    cout << str1 << endl;
    return 0;
}