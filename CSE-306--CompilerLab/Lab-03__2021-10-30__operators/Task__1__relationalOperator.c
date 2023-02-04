#include <stdio.h>
#include <stdbool.h>
int main(void) {
    char userString[5];
    bool isRelational=false;
    printf("Enter Operator: ");
    gets(userString);
    printf("The given Operator is ");
    switch(userString[0]) {
        case '>':
            if(userString[1] == '=') printf("Greater than or Equal");
            else printf("Grater than");
            isRelational = true;
            break;
        case '<':
            if(userString[1] == '=') printf("Less than or Equal");
            else printf("Less than");
            isRelational = true;
            break;
        case '=':
            if(userString[1] == '=') {
                printf("Equal to");
                isRelational = true;
            }
            else printf("Assignment");
            break;
        case '!':
            if(userString[1] == '=') {
                printf("Not Equal");
                isRelational = true;
            }
            else printf("Bit Not");
            break;
        case '&':
            if(userString[1] == '&') printf("Logical AND");
            else printf("Bitwise AND");
            break;
        case '|':
            if(userString[1] == '|') printf("Logical OR");
            else printf("Bitwise OR");
            break;
        case '+':
            if (userString[1] == '+') printf("Increment");
            else printf("Addition");
            break;
        case '−':
            if (userString[1] == '+') printf("Decrement");
            else printf("Substraction");
            break;
        case '*':
            printf("Multiplication");
            break;
        case '/':
            if (userString[1] != '/') printf("Division");
            else printf("not a Operator");
            break;
        case '%':
            printf("Modulus");
            break;
        default:
            printf("Not a operator");
    }
    if (isRelational) {
        printf(" and it is a Relational Operator\n");
    }
    else {
        printf(" and it is not a Relational Operator\n");
    }
    return 0;
}