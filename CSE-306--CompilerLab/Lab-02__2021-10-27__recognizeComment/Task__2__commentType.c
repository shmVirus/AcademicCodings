#include <stdbool.h>
#include <stdio.h>
#include <string.h>
int main(void) {
    bool commentTracker = false;
    int charArraySize;
    printf("Enter String Size: ");
    scanf("%d", &charArraySize);
    char userString[charArraySize];
    printf("Enter String: ");
    getchar();
    gets(userString);
    for (int i = 0; userString[i] != '\0'; i++) {
        if (userString[i] == '/') {
            if (userString[i + 1] == '/') {
                commentTracker = true;
                printf("The given String \"%s\" has a Single line Comment!\n", userString);
                break;
            } else if (userString[i + 1] == '*') {
                for (int j = i + 1; userString[j] != '\0'; j++) {
                    if (userString[j] == '*' && userString[j + 1] == '/') {
                        commentTracker = true;
                        printf("The given String \"%s\" has a Multi line Comment!\n", userString);
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
    }
    return 0;
}