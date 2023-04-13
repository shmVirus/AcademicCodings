#include <stdio.h>
int main(void) {
    char userString[5];
    printf("Enter a Operator: ");
    gets(userString);
    switch(userString[0]) {
        case '>':
            if(userString[1] == '=') printf("Greater than or Equal\n");
            else printf("Grater than\n");
            break;
        case '<':
            if(userString[1] == '=') printf("Less than or Equal\n");
            else printf("Less than\n");
            break;
        case '=':
            if(userString[1] == '=') printf("Equal to\n");
            else printf("Assignment\n");
            break;
        case '!':
            if(userString[1] == '=') printf("Not Equal\n");
            else printf("Bit Not\n");
            break;
        case '&':
            if(userString[1] == '&') printf("Logical AND\n");
            else printf("Bitwise AND\n");
            break;
        case '|':
            if(userString[1] == '|') printf("Logical OR\n");
            else printf("Bitwise OR\n");
            break;
        case '+':
            printf("Addition\n");
            break;
        case '−':
            printf("Substraction\n");
            break;
        case '*':
            printf("\nMultiplication\n");
            break;
        case '/':
            if (userString[1] != '/') printf("Division\n");
            break;
        case '%':
            printf("Modulus\n");
            break;
        default:
            printf("Not a operator\n");
    }
    return 0;
}