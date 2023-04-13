#include <stdbool.h>
#include <stdio.h>
#include <string.h>
int main(void) {
    bool commentTracker = false, isMultiline = false;
    int charArraySize, letterCount = 0, commentLength = 0;
    printf("Input String Size: ");
    scanf("%d", &charArraySize);
    char userString[charArraySize];
    printf("String: ");
    getchar();
    gets(userString);
    for (int i = 0; userString[i] != '\0'; i++) {
        if (userString[i] == '/') {
            if (userString[i + 1] == '/') {
                commentTracker = true;
                commentLength = strlen(userString) - (i + 2);
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
                        isMultiline = true;
                        commentLength = strlen(userString) - (i + 2 + 2);
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
    printf("\n");
    if (!commentTracker && strlen(userString) != 0) {
        printf("The given String \"%s\" has not any Comment!\n", userString);
    } else {
        if (!isMultiline) {
            printf("Comment Type: Single line Comment\nComment Length: %d characters\n", commentLength);
        } else {
            printf("Comment Type: Multi line Comment\nComment Length: %d characters\n", commentLength);
        }
        printf("Letter Numbers inside Comment: %d letters\n", letterCount);
    }
    return 0;
}