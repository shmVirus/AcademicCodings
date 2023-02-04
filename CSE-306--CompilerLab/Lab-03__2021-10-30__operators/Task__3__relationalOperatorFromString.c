#include <stdio.h>
#include <stdbool.h>
int main(void) {
    char userString[100];
    bool isRelational=false;
    int countRelationOperator=0;
    printf("Enter Operators: ");
    gets(userString);
    //printf("The given Operator has ");
    for(int i=0; userString[i] != '\0'; i++) {
        switch(userString[i]) {
        case '>':
            //if(userString[i+1] == '=') printf("Greater than or Equal");
            //else printf("Grater than");
            isRelational = true;
            countRelationOperator++;
            break;
        case '<':
            //if(userString[i+1] == '=') printf("Less than or Equal");
            //else printf("Less than");
            isRelational = true;
            countRelationOperator++;
            break;
        case '=': //<><><<=>=!=!==
            if(userString[i+1] == '=' && (userString[i-1] != '>' && userString[i-1] != '<' && userString[i-1] != '!')) {
                //printf("Equal to");
                isRelational = true;
                countRelationOperator++;
            }
            //else printf("Assignment");
            break;
        case '!':
            if(userString[i+1] == '=') {
                //printf("Not Equal");
                isRelational = true;
                countRelationOperator++;
            }
            //else printf("Bit Not");
            break;
        case '&':
            //if(userString[i+1] == '&') printf("Logical AND");
            //else printf("Bitwise AND");
            break;
        case '|':
            //if(userString[i+1] == '|') printf("Logical OR");
            //else printf("Bitwise OR");
            break;
        case '+':
            //if (userString[i+1] == '+') printf("Increment");
            //else printf("Addition");
            break;
        case '−':
            //if (userString[i+1] == '+') printf("Decrement");
            //else printf("Substraction");
            break;
        case '*':
            //printf("Multiplication");
            break;
        case '/':
            //if (userString[i+1] != '/') printf("Division");
            //else printf("not a Operator");
            break;
        case '%':
            //printf("Modulus");
            break;
        default:
            //printf("Not a operator");
    }
    }
    if (isRelational) {
        printf("\nTotal Relational Operators: %d\n", countRelationOperator);
    }
    else {
        printf("The given string has not any Relational Operator\n");
    }
    return 0;
}