#include <stdbool.h>
#include <stdio.h>
int main(void) {
    char userString[25];
    bool isRelational = false;
    printf("Enter Operator: ");
    gets(userString);
    
    for (int i = 0; i < userString[i] != '\0'; i++) {
        switch (userString[i]) {
            case '>':
                if (userString[i + 1] == '=') {
                    printf("At Index: %d %d\tGreater than or Equal\n", i, i++);
                } else {
                    printf("At Index: %d\tGreater than\n", i);
                }
                isRelational = true;
                break;
            case '<':
                if (userString[i + 1] == '=') {
                    printf("At Index: %d %d\tLess than or Equal\n", i, i++);
                } else {
                    printf("At Index: %d\tLess than\n", i);
                }
                isRelational = true;
                break;
            case '=':
                if (userString[i + 1] == '=') {
                    printf("At Index: %d %d\tEqual to\n", i, i++);
                    isRelational = true;
                }
                break;
            case '!':
                if (userString[i + 1] == '=') {
                    printf("At Index: %d %d\tNot Equal\n", i, i++);
                    isRelational = true;
                }
                break;
            case '&':
                if (userString[i + 1] == '&') {
                    printf("At Index: %d %d\tLogical AND\n", i, i++);
                }
                break;
            case '|':
                if (userString[i + 1] == '|') {
                    printf("At Index: %d %d\tLogical OR\n", i, i++);
                }
                break;
        }
    }
    if (!isRelational) {
        printf("Given Input does not contain any Relational Operator!\n");
    }
    return 0;
}