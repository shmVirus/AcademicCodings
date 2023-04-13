#include <stdbool.h>
#include <stdio.h>
#include <string.h>

int main(void) {
    char userString[175];
    int countArithmetic = 0, countRelational = 0, countLogical = 0, countBitWise = 0, countAssignment = 0, countTernary = 0;
    printf("Enter String: ");
    gets(userString);
    for (int i = 0; userString[i] != '\0'; i++) {
        if (userString[i] == '+' || userString[i] == '-' || userString[i] == '*' || userString[i] == '/' || userString[i] == '%') {
            if (userString[i] == '+' && userString[i + 1] == '+' || userString[i] == '-' && userString[i + 1] == '-') {
                countArithmetic++;
                i += 1;
            } else if (userString[i + 1] == '=') {
                countAssignment++;
                i += 1;
            } else {
                countArithmetic++;
            }
        } else if (userString[i] == '=') {
            if (userString[i + 1] == '=') {
                countRelational++;
                i += 1;
            } else {
                countAssignment++;
            }
        } else if (userString[i] == '>') {
            if (userString[i + 1] == '=') {
                countRelational++;
                i += 1;
            } else if (userString[i + 1] == '>') {
                if (userString[i + 2] == '=') {
                    countAssignment++;
                    i += 2;
                } else if (userString[i] == '>') {
                    countBitWise++;
                    i += 1;
                }
            } else {
                countRelational++;
            }
        } else if (userString[i] == '<') {
            if (userString[i + 1] == '=') {
                countRelational++;
                i += 1;
            } else if (userString[i + 1] == '<') {
                if (userString[i + 2] == '=') {
                    countAssignment++;
                    i += 2;
                } else if (userString[i + 1] == '<') {
                    countBitWise++;
                    i += 1;
                }
            } else {
                countRelational++;
            }
        } else if (userString[i] == '&') {
            if (userString[i + 1] == '&') {
                countLogical++;
                i += 1;
            } else if (userString[i + 1] == '=') {
                countAssignment++;
                i += 1;
            } else {
                countBitWise++;
            }
        } else if (userString[i] == '|') {
            if (userString[i + 1] == '|') {
                countLogical++;
                i += 1;
            } else if (userString[i + 1] == '=') {
                countAssignment++;
                i += 1;
            } else {
                countBitWise++;
            }
        } else if (userString[i] == '!') {
            if (userString[i + 1] == '=') {
                countRelational++;
                i += 1;
            } else {
                countLogical++;
            }
        } else if (userString[i] == '^') {
            if (userString[i + 1] == '=') {
                countAssignment++;
                i += 1;
            } else {
                countBitWise++;
            }
        } else if (userString[i] == '~') {
            countBitWise++;
        } else if (userString[i] == '?' && userString[i + 1] == ':') {
            countTernary++;
        }
    }
    printf("Total Bitwise Operators: %d\n", countBitWise);
    printf("Total Logical Operators: %d\n", countLogical);
    printf("Total Ternary Operators: %d\n", countTernary);
    printf("Total Arithmetic Operators: %d\n", countArithmetic);
    printf("Total Assignment Operators: %d\n", countAssignment);
    printf("Total Relational Operators: %d\n", countRelational);
    return 0;
}