#include <stdbool.h>
#include <stdio.h>
int main(void) {
    char terminals[100], nonTerminals[100], inputString[100];
    int ter = 0, non = 0;
    printf("Enter the Rule: ");
    fgets(inputString, 100, stdin);
    terminals[0] = '\0', nonTerminals[0] = '\0';

    for (int i = 0; inputString[i] != '\0'; i++) {
        if (inputString[i] >= 'A' && inputString[i] <= 'Z') {
            bool isListed = false;
            for (int j = 0; nonTerminals[j] != '\0'; j++) {
                if (nonTerminals[j] == inputString[i]) {
                    isListed = true;
                }
            }
            if (!isListed) {
                nonTerminals[non++] = inputString[i];
            }
        } else if (inputString[i] == '|' || inputString[i] == ' ' || (inputString[i] == '-' && inputString[++i] == '>')) {
            continue;
        } else {
            bool isListed = false;
            for (int j = 0; terminals[j] != '\0'; j++) {
                if (terminals[j] == inputString[i]) {
                    isListed = true;
                }
            }
            if (!isListed) {
                terminals[ter++] = inputString[i];
            }
        }
    }
    terminals[ter] = '\0';
    nonTerminals[non] = '\0';

    printf("NonTerminals: ");
    for (int i = 0; nonTerminals[i] != '\0'; i++) {
        printf("%c", nonTerminals[i]);
        if (nonTerminals[i + 1] == '\0') {
            printf("\n");
        } else {
            printf(", ");
        }
    }
    printf("Terminals: ");
    for (int i = 0; terminals[i] != '\0'; i++) {
        printf("%c", terminals[i]);
        if (terminals[i + 1] == '\0') {
            printf("\n");
        } else {
            printf(", ");
        }
    }
    return 0;
}