#include <stdio.h>
#include <string.h>
int main(void) {
    int lineNumbers;
    printf("Line Numbers: ");
    scanf("%d", &lineNumbers);
    getchar();
    char userString[lineNumbers][75];
    for (int i = 0; i < lineNumbers; i++) {
        printf("Enter %d-th String: ", i + 1);
        gets(userString[i]);
    }
    for (int i = 0; i < lineNumbers; i++) {
        for (int j = 0; userString[i][j] != '\0'; j++) {
            if (userString[i][j] == '/') {
                if (userString[i][j + 1] == '/') {
                    userString[i][j] = userString[i][strlen(userString[i]) + 1];
                    break;
                } else if (userString[i][j + 1] == '*') {
                    for (int k = j + 1; userString[i][k] != '\0'; k++) {
                        if (userString[i][k] == '*' && userString[i][k + 1] == '/') {
                            int t = j;
                            for (int l = k + 2; userString[i][l] != '\0'; l++) {
                                userString[i][t] = userString[i][l];
                                t++;
                            }
                            userString[i][t] = '\0';
                            break;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }
    for (int i = 0; i < lineNumbers; i++) {
        printf("Modified %d-th String: ", i + 1);
        puts(userString[i]);
    }
    return 0;
}