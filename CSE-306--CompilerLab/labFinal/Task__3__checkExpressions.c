#include <stdio.h>
int main(void) {
    char userString[75], c;
    int state = 0, i = 0;
    printf("String: ");
    gets(userString);
    while (userString[i] != '\0' && state != -1) {
        if (state == 0) {
            c = userString[i++];
            if (c == 'a') {
                state = 1;
            } else {
                state = -1;
            }
        } else if (state == 1) {
            c = userString[i++];
            if (c == 'a') {
                state = 1;
            } else if (c == 'b') {
                state = 2;
            } else if (c == 'c') {
                state = 3;
            } else {
                state = -1;
            }
        } else if (state == 2) {
            c = userString[i++];
            if (c == 'b') {
                state = 2;
            } else if (c == 'c') {
                state = 3;
            } else {
                state = -1;
            }
        } else if (state == 3) {
            c = userString[i++];
            if (c == 'c') {
                state = 3;
            } else {
                state = -1;
            }
        }
    }
    if (state == 3) {
        printf("Given Input is Accepted through a+b*c+\n");
    } else {
        printf("Given Input is not Accepted through a+b*c+\n");
    }
    return 0;
}