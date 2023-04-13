#include <iostream>
#include <cstdlib>
#include <ctime>
int main() {
    srand((unsigned) time(0));
    int arrayStorage[10], arrayIndex, sumFor=0, sumWhile=0;
    for(arrayIndex=0; arrayIndex<10; arrayIndex++) {
        arrayStorage[arrayIndex] = rand() % 100;
        sumFor += arrayStorage[arrayIndex];
    }
    while (arrayIndex!=0) {
        sumWhile += arrayStorage[--arrayIndex];
    }
    std:: cout << "Summation using \"For\" loop = " << sumFor << std:: endl;
    std:: cout << "Summation using \"While\" loop = " << sumWhile << std:: endl;
    return 0;
}