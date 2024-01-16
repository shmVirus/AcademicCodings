#include <iostream>
int stackIndex=-1,stackStorage[50];
int main() {
    char userExpression[50], X,Y;
    std:: cin >> userExpression;
    for(int i=0; userExpression[i]!='\0'; i++) {
        if(userExpression[i]>='0' && userExpression[i]<='9') {
            stackStorage[++stackIndex] = userExpression[i]-48;
        } else {
            Y = stackStorage[stackIndex--];
            X = stackStorage[stackIndex];
            switch (userExpression[i]) {
            case '+':
                stackStorage[stackIndex] = X+Y;
                break;
            case '-':
                stackStorage[stackIndex] = X-Y;
                break;
            case '*':
                stackStorage[stackIndex] = X*Y;
                break;
            case '/':
                stackStorage[stackIndex] = X/Y;
                break;
            case '%':
                stackStorage[stackIndex] = X%Y;
            }
        }
    }
    std:: cout << stackStorage[stackIndex] << std:: endl;
    return 0;
}
