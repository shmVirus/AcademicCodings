#include <stdio.h>

char stack[100];
int top = -1;

void push(char popChar) {
    stack[++top] = popChar;
}
char pop() {
    if (top == -1) {
        return -1;
    } else {
        return stack[top--];
    }
}

int bodmasPrecedence(char popChar) {
    if (popChar == '(') {
        return 0;
    } else if (popChar == '+' || popChar == '-') {
        return 1;
    } else if (popChar == '*' || popChar == '/') {
        return 2;
    } else if (popChar == '^') {
        return 3;
    }
    return 0;
}

int main(void) {
    char infix[100], reverseInfix[100];
    char prefix[100], reversePrefix[100];
    char postfix[100];
    char *pointToInfix, popChar;
    printf("Infix: ");
    scanf("%s", infix);

    pointToInfix = infix;
    int i = 0, j = 0;
    while (*pointToInfix != '\0') {
        if (isalnum(*pointToInfix)) {
            postfix[i++] = *pointToInfix;
        } else if (*pointToInfix == '(') {
            push(*pointToInfix);
        } else if (*pointToInfix == ')') {
            while ((popChar = pop()) != '(') {
                postfix[i++] = popChar;
            }
        } else {
            while (bodmasPrecedence(stack[top]) >= bodmasPrecedence(*pointToInfix)) {
                postfix[i++] = pop();
            }
            push(*pointToInfix);
        }
        pointToInfix++;
    }
    while (top != -1) {
        postfix[i++] = pop();
    }
    postfix[i] = '\0';

    i = strlen(infix);
    while (infix[j] != '\0') {
        reverseInfix[j++] = infix[--i];
    }
    i = -1;
    while (reverseInfix[++i] != '\0') {
        if (reverseInfix[i] == ')') {
            reverseInfix[i] = '(';
        } else if (reverseInfix[i] == '(') {
            reverseInfix[i] = ')';
        }
    }
    pointToInfix = reverseInfix;
    i = 0;
    while (*pointToInfix != '\0') {
        if (isalnum(*pointToInfix)) {
            reversePrefix[i++] = *pointToInfix;
        } else if (*pointToInfix == '(') {
            push(*pointToInfix);
        } else if (*pointToInfix == ')') {
            while ((popChar = pop()) != '(') {
                reversePrefix[i++] = popChar;
            }
        } else {
            while (bodmasPrecedence(stack[top]) >= bodmasPrecedence(*pointToInfix)) {
                reversePrefix[i++] = pop();
            }
            push(*pointToInfix);
        }
        pointToInfix++;
    }
    while (top != -1) {
        reversePrefix[i++] = pop();
    }
    j = 0;
    while (reversePrefix[j] != '\0') {
        prefix[j++] = reversePrefix[--i];
    }
    prefix[j] = '\0';

    printf("Prefix: %s\n", prefix);
    printf("Postfix: %s\n", postfix);
    return 0;
}