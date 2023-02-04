#include <stdio.h>
#include <string.h>
int main(void) {
    char t[5], nt[10], p[5][5], first[5][5], temp;
    int i, j, terminal, nonTerminal, k = 0, f = 0;
    printf("\nEnter the no. of Non-terminals in the grammer:");
    scanf("%d", &nonTerminal);
    printf("\nEnter the Non-terminals in the grammer:\n");
    for (i = 0; i < nonTerminal; i++) {
        scanf("\n%c", &nt[i]);
    }
    printf("\nEnter the no. of Terminals in the grammer: ( Enter e for absiline ) ");
    scanf("%d", &terminal );
    printf("\nEnter the Terminals in the grammer:\n");
    for (i = 0; i < terminal || t[i] == '$'; i++) {
        scanf("\n%c", &t[i]);
    }
    for (i = 0; i < nonTerminal; i++) {
        p[i][0] = nt[i];
        first[i][0] = nt[i];
    }
    printf("\nEnter the productions :\n");
    for (i = 0; i < nonTerminal; i++) {
        scanf("%c", &temp);
        printf("\nEnter the production for %c ( End the production with '$' sign ):", p[i][0]);
        for (j = 0; p[i][j] != '$';) {
            j += 1;
            scanf("%c", &p[i][j]);
        }
    }
    for (i = 0; i < nonTerminal; i++) {
        printf("\nThe production for %c -> ", p[i][0]);
        for (j = 1; p[i][j] != '$'; j++) {
            printf("%c", p[i][j]);
        }
    }
    for (i = 0; i < nonTerminal; i++) {
        f = 0;
        for (j = 1; p[i][j] != '$'; j++) {
            for (k = 0; k < terminal ; k++) {
                if (f == 1)
                    break;
                if (p[i][j] == t[k]) {
                    first[i][j] = t[k];
                    first[i][j + 1] = '$';
                    f = 1;
                    break;
                } else if (p[i][j] == nt[k]) {
                    first[i][j] = first[k][j];
                    if (first[i][j] == 'e')
                        continue;
                    first[i][j + 1] = '$';
                    f = 1;
                    break;
                }
            }
        }
    }
    for (i = 0; i < nonTerminal; i++) {
        printf("\n\nThe first of %c -> ", first[i][0]);
        for (j = 1; first[i][j] != '$'; j++) {
            printf("%c\t", first[i][j]);
        }
    }
    return 0;
}