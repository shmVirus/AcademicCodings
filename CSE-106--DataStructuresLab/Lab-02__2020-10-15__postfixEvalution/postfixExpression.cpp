#include <iostream>

int stackIndex=-1, stackStorage[50];
void pushValue(int temp) {
    if (stackIndex==49) {
        std:: cout << "Stack is Full" << std:: endl;
    }
    else {
        stackStorage[++stackIndex] = temp;
    }
}
int popValue() {
    if (stackIndex==-1) {
        std:: cout << "Stack is Empty" << std:: endl;
    }
    else {
        return stackStorage[stackIndex--];
    }
}

int main() {
    char userExpression[50];
    std:: cin >> userExpression;
    for(int i=0; userExpression[i]!='\0'; i++) {
        if(userExpression[i]>='0' && userExpression[i]<='9') {
            pushValue(userExpression[i]-48);
        } else {
            int Y = popValue();
            int X = popValue();
            switch (userExpression[i]) {
            case '+':
                pushValue(X+Y);
                break;
            case '-':
                pushValue(X-Y);
                break;
            case '*':
                pushValue(X*Y);
                break;
            case '/':
                pushValue(X/Y);
                break;
            case '%':
                pushValue(X%Y);
            }
        }
    }
    std:: cout << stackStorage[stackIndex] << std:: endl;
    return 0;
}