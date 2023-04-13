#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
    int a = 0, b = 0, c;
    char str[20], tok[11];
    printf("Input the expression = ");
    gets(str);
    while (str[a] != '\0') {
        if ((str[a] == '(') || (str[a] == '{')) {
            tok[b] = '4';
            b++;
        }
        if ((str[a] == ')') || (str[a] == '}')) {
            tok[b] = '5';
            b++;
        }
        if (str[a] >= '0' && str[a] <= '9') {
            while (isdigit(str[a])) {
                a++;
            }
            a--;
            tok[b] = '6';
            b++;
        }
        if (str[a] == '+') {
            tok[b] = '2';
            b++;
        }
        if (str[a] == '*') {
            tok[b] = '3';
            b++;
        }
        a++;
    }
    tok[b] = '\0';
    puts(tok);
    b = 0;
    while (tok[b] != '\0') {
        if (((tok[b] == '6') && (tok[b + 1] == '2') && (tok[b + 2] == '6')) || ((tok[b] == '6') && (tok[b + 1] == '3') && (tok[b + 2] == '6')) || ((tok[b] == '4') && (tok[b + 1] == '6') && (tok[b + 2] == '5')) /*||((tok[b]!=6)&&(tok[b+1]!='\0'))*/) {
            tok[b] = '6';
            c = b + 1;
            while (tok[c] != '\0') {
                tok[c] = tok[c + 2];
                c++;
            }
            tok[c] = '\0';
            puts(tok);
            b = 0;
        } else {
            b++;
            puts(tok);
        }
    }
    int d;
    d = strcmp(tok, "6");
    printf("d = %d\n", d);
    if (d == 0) {
        printf("It is in the grammar.\n");
    } else {
        printf("It is not in the grammar.\n");
    }
    return 0;
}