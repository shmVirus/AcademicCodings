#include <stdbool.h>
#include <stdio.h>
int main(void) {
    char nonTerminals[100], inputString[5];
    int indexTracker=0, x=0;
    printf("Enter the Rule: ");
    fgets(inputString, 100, stdin);
    printf("%s\n", inputString);
    printf("NonTerminals: \n");
    for (int i = 0; inputString[i] != '\0'; i++) {
        if (inputString[i] >= 'A' && inputString[i] <= 'Z') {
            bool isListed = false;
            for (int j = 0; nonTerminals[j] != '\0'; j++) {
                if (nonTerminals[j] == inputString[i]) {
                    isListed = true;
                }
            }
            if (!isListed) {
                x = 1;
                nonTerminals[indexTracker] = inputString[i];
                printf("\t%c at %d-th Index\n", nonTerminals[indexTracker++], i);
            }
            //printf("\t%c at %d-th Index\n", inputString[i], i);
        }
    }
    if (!x) printf ("\tNo Non-Terminals Found!\n");
    return 0;
}