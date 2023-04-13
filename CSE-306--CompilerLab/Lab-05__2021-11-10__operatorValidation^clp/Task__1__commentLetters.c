#include <stdbool.h>
#include <stdio.h>
#include <string.h>
int main(void) {
    bool commentTracker = false;
    char userString[75];
    int letterCount = 0;
    printf("Enter String: ");
    getchar();
    gets(userString);
    for (int i = 0; userString[i] != '\0'; i++) {
        if (userString[i] == '/') {
            if (userString[i + 1] == '/') {
                commentTracker = true;
                for (int k = i + 2; userString[k] != '\0'; k++) {
                    if (userString[k] >= 'a' && userString[k] <= 'z' || userString[k] >= 'A' && userString[k] <= 'Z') {
                        letterCount++;
                    }
                }
                break;
            } else if (userString[i + 1] == '*') {
                for (int j = i + 1; userString[j] != '\0'; j++) {
                    if (userString[j] == '*' && userString[j + 1] == '/') {
                        commentTracker = true;
                        for (int k = i + 2; userString[k] != '\0'; k++) {
                            if (userString[k] >= 'a' && userString[k] <= 'z' || userString[k] >= 'A' && userString[k] <= 'Z') {
                                letterCount++;
                            }
                        }
                        break;
                    } else {
                        continue;
                    }
                }
            }
        }
    }
    if (!commentTracker && strlen(userString) != 0) {
        printf("The given String \"%s\" has not any Comment!\n", userString);
    } else {
        printf("Letters inside Comment: %d letters\n", letterCount);
    }
    return 0;
}