#include <iostream>

int i=0,stk[50];

void push(int a) {
    i++;
    stk[i]=a;
}

int pop() {
    int b;
    b=stk[i];
    i--;
    return b;
}

int main() {
    char userInput[50];
    int j,a,b;
    scanf("%[^\n]",userInput);
    for(j=0; userInput[j]!='\0'; j++);
    for(j=j-1; j>=0; j--)
        if(userInput[j]>='0'&&userInput[j]<='9')
            push(userInput[j]-48);
        else if(userInput[j]=='*') {
            a=pop();
            b=pop();
            push(a*b);
        } else if(userInput[j]=='/') {
            a=pop();
            b=pop();
            push(a/b);
        } else if(userInput[j]=='+') {
            a=pop();
            b=pop();
            push(a+b);
        } else if(userInput[j]=='-') {
            a=pop();
            b=pop();
            push(a-b);
        }

    printf("%d",pop());

    return 0;
}
