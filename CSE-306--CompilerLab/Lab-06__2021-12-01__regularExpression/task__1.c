#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//* Expression: aba

/*
? state 1 - a
? state 2 - b
? state 0 - anything
*/

int main(void) {
    char s[30], c;
    int state = 0, i = 0;
    printf("Enter a String: ");
    fgets(s, 30, stdin);
    printf("Given String: %s\n", s);
    while (s[i] != '\0') {
        switch (state) {
            case 0:
                c = s[i++];
                if (c = 'a') {
                    state = 1;
                } else {
                    state = 0;
                }
                printf("0-");
                break;
            case 1:
                c = s[i++];
                if (c = 'b') {
                    state = 2;
                } else {
                    state = 0;
                }
                printf("1-");
                break;
            case 2:
                c = s[i++];
                if (c = 'a') {
                    state = 1;
                } else {
                    state = 0;
                }
                printf("2-");
                break;
        }
    }

    if (state == 1) {
        printf("%s is accepted through aba\n", s);
    } else {
        printf("%s is not accepted\n", s);
    }
    return 0;
}