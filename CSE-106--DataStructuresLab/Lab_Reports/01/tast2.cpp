#include <iostream>

int stackIndex=-1, stackStorage[3];

void pushValue(int temp) {
    if (stackIndex==2) {
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
    pushValue(10);
    pushValue(20);
    popValue();
    popValue();
    popValue();
    pushValue(50);
    popValue();
    return 0;
}