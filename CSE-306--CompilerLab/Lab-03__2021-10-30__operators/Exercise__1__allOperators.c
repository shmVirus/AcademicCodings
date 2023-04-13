#include <stdbool.h>
#include <stdio.h>
#include <string.h>
int main(void) {
    char userString[175];
    int insert = -1;
    int countArithmetic = 0, countRelational = 0, countLogical = 0, countBitWise = 0, countAssignment = 0, countUnary = 0, countTernary = 0, countBinary = 0;
    //int trackArithmetic = 0, trackRelational = 0, trackLogical = 0, trackBitWise = 0, trackAssignment = 0, trackUnary = 0, trackTernary = 0, trackBinary = 0;
    char showArithmetic[175], showRelational[175], showLogical[175], showBitWise[175], showAssignment[175], showUnary[175], showTernary[175], showBinary[175];
    printf("Enter String: ");
    gets(userString);
    for (int i = 0; userString[i] != '\0'; i++) {
        if (userString[i] == '+' || userString[i] == '-' || userString[i] == '*' || userString[i] == '/' || userString[i] == '%') {
            if (userString[i] == '+' && userString[i + 1] == '+' || userString[i] == '-' && userString[i + 1] == '-') {
                countArithmetic++;
                insert = strlen(showArithmetic);
                showArithmetic[insert++] = userString[i];
                showArithmetic[insert++] = userString[i + 1];
                showArithmetic[insert++] = ',';
                showArithmetic[insert++] = ' ';
                i += 1;
                continue;
            } else if (userString[i + 1] == '=') {
                countAssignment++;
                insert = strlen(showAssignment);
                showAssignment[insert++] = userString[i];
                showAssignment[insert++] = userString[i + 1];
                showAssignment[insert++] = ',';
                showAssignment[insert++] = ' ';
                i += 1;
                continue;
            } else if (userString[i] == '+' || userString[i] == '-' || userString[i] == '*' || userString[i] == '/' || userString[i] == '%') {
                countArithmetic++;
                insert = strlen(showArithmetic);
                showArithmetic[insert++]  = userString[i];
                showArithmetic[insert++] = ',';
                showArithmetic[insert++] = ' ';
            }
        } else if (userString[i] == '=') {
            if (userString[i + 1] == '=') {
                countRelational++;
                insert = strlen(showRelational);
                showRelational[insert++]  = userString[i];
                showRelational[insert++] = userString[i + 1];
                showRelational[insert++] = ',';
                showRelational[insert++] = ' ';
                i += 1;
                continue;
            } else if (userString[i] == '=') {
                countAssignment++;
                insert = strlen(showAssignment);
                showAssignment[insert++]  = userString[i];
                showAssignment[insert++] = ',';
                showAssignment[insert++] = ' ';
            }
        } else if (userString[i] == '>') {
            if (userString[i + 1] == '=') {
                countRelational++;
                insert = strlen(showRelational);
                showRelational[insert++]  = userString[i];
                showRelational[insert++] = userString[i + 1];
                showRelational[insert++] = ',';
                showRelational[insert++] = ' ';
                i += 1;
                continue;
            } else if (userString[i + 1] == '>') {
                if (userString[i + 2] == '=') {
                    countAssignment++;
                    insert = strlen(showAssignment);
                    showAssignment[insert++]  = userString[i];
                    showAssignment[insert++] = userString[i + 1];
                    showAssignment[insert++] = userString[i + 2];
                    showAssignment[insert++] = ',';
                    showAssignment[insert++] = ' ';
                    i += 2;
                    continue;
                } else if (userString[i] == '>') {
                    countBitWise++;
                    insert = strlen(showBitWise);
                    showBitWise[insert++]  = userString[i];
                    showBitWise[insert++] = userString[i + 1];
                    showBitWise[insert++] = ',';
                    showBitWise[insert++] = ' ';
                    i += 1;
                    continue;
                }
            } else if (userString[i] == '>') {
                countRelational++;
                insert = strlen(showRelational);
                showRelational[insert++]  = userString[i];
                showRelational[insert++] = ',';
                showRelational[insert++] = ' ';
            }
        } else if (userString[i] == '<') {
            if (userString[i + 1] == '=') {
                countRelational++;
                insert = strlen(showRelational);
                showRelational[insert++]  = userString[i];
                showRelational[insert++] = userString[i + 1];
                showRelational[insert++] = ',';
                showRelational[insert++] = ' ';
                i += 1;
                continue;
            } else if (userString[i + 1] == '<') {
                if (userString[i + 2] == '=') {
                    countAssignment++;
                    insert = strlen(showAssignment);
                    showAssignment[insert++]  = userString[i];
                    showAssignment[insert++] = userString[i + 1];
                    showAssignment[insert++] = userString[i + 2];
                    showAssignment[insert++] = ',';
                    showAssignment[insert++] = ' ';
                    i += 2;
                    continue;
                } else if (userString[i + 1] == '<') {
                    countBitWise++;
                    insert = strlen(showBitWise);
                    showBitWise[insert++]  = userString[i];
                    showBitWise[insert++] = userString[i + 1];
                    showBitWise[insert++] = ',';
                    showBitWise[insert++] = ' ';
                    i += 1;
                    continue;
                }
            } else if (userString[i] == '<') {
                countRelational++;
                insert = strlen(showRelational);
                showRelational[insert++]  = userString[i];
                showRelational[insert++] = ',';
                showRelational[insert++] = ' ';
            }
        } else if (userString[i] == '&') {
            if (userString[i + 1] == '&') {
                countLogical++;
                insert = strlen(showLogical);
                showLogical[insert++]  = userString[i];
                showLogical[insert++] = userString[i + 1];
                showLogical[insert++] = ',';
                showLogical[insert++] = ' ';
                i += 1;
                continue;
            } else if (userString[i + 1] == '=') {
                countAssignment++;
                insert = strlen(showAssignment);
                showAssignment[insert++]  = userString[i];
                showAssignment[insert++] = userString[i + 1];
                showAssignment[insert++] = ',';
                showAssignment[insert++] = ' ';
                i += 1;
                continue;
            } else if (userString[i] == '&') {
                countBitWise++;
                insert = strlen(showBitWise);
                showBitWise[insert++]  = userString[i];
                showBitWise[insert++] = ',';
                showBitWise[insert++] = ' ';
            }
        } else if (userString[i] == '|') {
            if (userString[i + 1] == '|') {
                countLogical++;
                insert = strlen(showLogical);
                showLogical[insert++]  = userString[i];
                showLogical[insert++] = userString[i + 1];
                showLogical[insert++] = ',';
                showLogical[insert++] = ' ';
                i += 1;
                continue;
            } else if (userString[i + 1] == '=') {
                countAssignment++;
                insert = strlen(showAssignment);
                showAssignment[insert++]  = userString[i];
                showAssignment[insert++] = userString[i + 1];
                showAssignment[insert++] = ',';
                showAssignment[insert++] = ' ';
                i += 1;
                continue;
            } else if (userString[i] == '|') {
                countBitWise++;
                insert = strlen(showBitWise);
                showBitWise[insert++]  = userString[i];
                showBitWise[insert++] = ',';
                showBitWise[insert++] = ' ';
            }
        } else if (userString[i] == '!') {
            if (userString[i + 1] == '=') {
                countRelational++;
                insert = strlen(showRelational);
                showRelational[insert++]  = userString[i];
                showRelational[insert++] = userString[i + 1];
                showRelational[insert++] = ',';
                showRelational[insert++] = ' ';
                i += 1;
                continue;
            } else if (userString[i] == '!') {
                countLogical++;
                insert = strlen(showLogical);
                showLogical[insert++]  = userString[i];
                showLogical[insert++] = ',';
                showLogical[insert++] = ' ';
            }
        } else if (userString[i] == '^') {
            if (userString[i + 1] == '=') {
                countAssignment++;
                insert = strlen(showAssignment);
                showAssignment[insert++]  = userString[i];
                showAssignment[insert++] = userString[i + 1];
                showAssignment[insert++] = ',';
                showAssignment[insert++] = ' ';
                i += 1;
                continue;
            } else if (userString[i] == '^') {
                countBitWise++;
                insert = strlen(showBitWise);
                showBitWise[insert++]  = userString[i];
                showBitWise[insert++] = ',';
                showBitWise[insert++] = ' ';
            }
        } else if (userString[i] == '~') {
            countBitWise++;
            insert = strlen(showBitWise);
            showBitWise[insert++]  = userString[i];
            showBitWise[insert++] = ',';
            showBitWise[insert++] = ' ';
        }
    }
    if (strlen(showRelational) != 0) {
        insert = strlen(showRelational);
        showRelational[insert - 2] = '\0';
    }
    if (strlen(showArithmetic) != 0) {
        insert = strlen(showArithmetic);
        showArithmetic[insert - 2] = '\0';
    }
    if (strlen(showAssignment) != 0) {
        insert = strlen(showAssignment);
        showAssignment[insert - 2] = '\0';
    }
    if (strlen(showLogical) != 0) {
        insert = strlen(showLogical);
        showLogical[insert - 2] = '\0';
    }
    if (strlen(showBitWise) != 0) {
        insert = strlen(showBitWise);
        showBitWise[insert - 2] = '\0';
    }
    printf("Total Relational Operators: %d; %s\n", countRelational, showRelational);
    printf("Total Arithmetic Operators: %d; %s\n", countArithmetic, showArithmetic);
    printf("Total Assignment Operators: %d; %s\n", countAssignment, showAssignment);
    printf("Total Logical Operators: %d; %s\n", countLogical, showLogical);
    printf("Total Bitwise Operators: %d; %s\n", countBitWise, showBitWise);
    return 0;
}