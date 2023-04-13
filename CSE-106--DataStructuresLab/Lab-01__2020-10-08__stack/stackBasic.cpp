#include <iostream>

int stackIndex=-1, stackStorage[5];

void pushValue(int temp) {
    if (stackIndex==4) {
        std:: cout << "Stack is Full" << std:: endl;
    }
    else {
        stackStorage[++stackIndex] = temp;
    }
}

void popValue() {
    if (stackIndex==-1) {
        std:: cout << "Stack is Empty" << std:: endl;
    }
    else {
        std:: cout << stackStorage[stackIndex--] << std:: endl;
    }
}

int main() {
    pushValue(50);
    pushValue(40);
    pushValue(30);
    pushValue(20);
    pushValue(10);
    popValue();
    popValue();
    popValue();
    popValue();
    popValue();
    return 0;
}