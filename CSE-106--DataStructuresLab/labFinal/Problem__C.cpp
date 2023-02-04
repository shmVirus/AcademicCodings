#include <iostream>

int stackIndex=-1, stackStorage[50], minStack[50];

void pushValue(int temp) {
    if (stackIndex==49) {
        std:: cout << "Stack is Full" << std:: endl;
    }
    else {
        if (stackIndex==-1) {
            stackIndex++;
            stackStorage[stackIndex] = temp;
            minStack[stackIndex] = temp;
        }
        else {
            if (temp > minStack[stackIndex]) {
                stackIndex++;
                stackStorage[stackIndex] = temp;
                minStack[stackIndex] = minStack[stackIndex-1];
            }
            else {
                stackIndex++;
                stackStorage[stackIndex] = temp;
                minStack[stackIndex] = temp;
            }
        }
    }
}
int popValue() {
    if (stackIndex==-1) {
        std:: cout << "Stack is Empty" << std:: endl;
    }
    else {
        return minStack[stackIndex--];
    }
}

int main() {
    int listSize=7;
    int userList[listSize] = {1, 6, 43, 1, 2, 0, 5};
    for(int i=0; i<listSize; i++) {
        pushValue(userList[i]);
    }
    for(int i=0; i<listSize; i++) {
        std:: cout << popValue();
        if (i+1 != listSize) {
            std:: cout << " ";
        } else {
            std:: cout << std:: endl;
        }
    }
    return 0;
}