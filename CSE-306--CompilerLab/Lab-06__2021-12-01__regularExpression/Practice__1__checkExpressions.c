#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/* 6 state 1, 3 = a* | aaaa
state 2, 4 = a*b+ | bbbb
state 5 = abb | abb
state 6 = invalid
*/
int main() {
    char s[30], c;
    int state = 1, i = 0;
    printf("Enter a string\n");
    fgets(s, 30, stdin);
    printf("data is %s", s);
    while (s[i] != '\0') {
        switch (state) {
            case 0:
                c = s[i++];
                // c == don't know
                if (c == 'b')
                    state = 1;
                else if (c == 'a')
                    state = 2;
                else
                    state = 1;
                break;
            case 1:
                c = s[i++];
                // c = a
                if (c == '\n') {
                    break;
                }
                if (c == 'b') {
                    state = 3;
                } else if (c == 'a')
                    state = 4;
                else
                    state = 6;
                break;
            case 2:
                c = s[i++];
                // c = b
                if (c == '\n') {
                    break;
                }
                if (c == 'a') {
                    state = 6;
                } else if (c == 'b') {
                    state = 2;
                } else
                    state = 6;
                break;
            case 3:
                c = s[i++];
                // c = aa
                if (c == '\n') {
                    break;
                }
                if (c == 'a') {
                    state = 3;
                } else if (c == 'b')
                    state = 2;
                else
                    state = 6;
                break;
            case 4:
                c = s[i++];
                // ab
                if (c == '\n') {
                    break;
                }
                if (c == 'a') {
                    state = 6;
                } else if (c == 'b') {
                    state = 5;
                } else
                    state = 6;
                break;
            case 5:
                c = s[i++];
                // abb
                if (c == '\n') {
                    break;
                }
                if (c == 'a') {
                    state = 6;
                } else if (c == 'b') {
                    state = 2;
                } else
                    state = 6;
                break;
            case 6:
                c == s[i++];
                printf("data = %c and state = %d\n", c,
                       state);
                break;
        }
        if (state == 1 || state == 3) {
            printf("%s is accepted through b*", s);
        } else if (state == 2 || state == 4) {
            printf("%s is accepted through a+b*", s);
        } else if (state == 5) {
            printf("%s is accepted through abb", s);
        } else {
            printf("%s is not accepted", s);
        }
        return 0;
    }
}