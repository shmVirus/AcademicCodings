#include <stdio.h>
#include <string.h>
int main(void) {
    int lineNumbers;
    printf("Enter Line Numbers: ");
    scanf("%d", &lineNumbers);
    getchar();
    char userString[lineNumbers][75];
    int commentsInLine[lineNumbers];
    int commentsTracker = -1;
    for (int i = 0; i < lineNumbers; i++) {
        printf("Enter %d-th String: ", i + 1);
        gets(userString[i]);
    }
    for (int i = 0; i < lineNumbers; i++) {
        for (int j = 0; userString[i][j] != '\0'; j++) {
            if (userString[i][j] == '/') {
                if (userString[i][j + 1] == '/') {
                    commentsInLine[++commentsTracker] = i;
                    break;
                } else if (userString[i][j + 1] == '*') {
                    for (int k = j + 1; userString[i][k] != '\0'; k++) {
                        if (userString[i][k] == '*' && userString[i][k + 1] == '/') {
                            commentsInLine[++commentsTracker] = i;
                            break;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }
    if (commentsTracker == -1) {
        printf("The given Strings has not any Comment!\n");
    } else {
        printf("Line Numbers that have Comments: ");
        for (int i = 0; i <= commentsTracker; i++) {
            printf("%d-th", commentsInLine[i] + 1);
            if (i == commentsTracker) {
                printf("\n");
            } else {
                printf(", ");
            }
        }
    }
    return 0;
}