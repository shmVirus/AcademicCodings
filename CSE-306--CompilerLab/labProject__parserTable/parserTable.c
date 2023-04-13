#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#define terminalSize 128    // ? 128 because ASCII range
#define nonTerminalSize 26  // ? 26 because range of A-Z

int noOfRules = 0;
bool terminals[terminalSize];        // * terminals[i] = true means i-th index/char is a terminal
bool nonTerminals[nonTerminalSize];  // * nonTerminals[i] = true means i-th index/char is a non-terminal, A-Z
bool first[nonTerminalSize][terminalSize];
bool follow[nonTerminalSize][terminalSize];
bool firstEmpty[100][terminalSize];  // * stores first of each production in form A->B
int table[100][terminalSize];        // * table[i][j] stores the index of production that must be applied on i-th variable if the input is j-th nonTerminals

struct product {     // * structure to hold each production
    char rule[100];  // * rule[] stores the production
    int length;      // * length is the length of production
} productionRules[20];

bool isNonTerminal(char selectedChar) {                 // * check if the symbol is nonTerminal
    return selectedChar >= 'A' && selectedChar <= 'Z';  // ? returns true while the character is nonTerminal
}

void updateFirstForEmptyFirst(char A, int B) {
    for (int i = 0; i < terminalSize; i++) {
        if (i != '^') {
            firstEmpty[B][i] = first[A - 'A'][i] || firstEmpty[B][i];
        }
    }
}
void findFirstWhenFirstIsEmpty() {  // * Calculates FIRST(B) for each A->B
    for (int t = 0; t < noOfRules; t++) {
        for (int i = 0, j = 3; i < noOfRules; i++, j = 3) {
            for (j; j < productionRules[i].length; j++) {
                char selectedChar = productionRules[i].rule[j];
                if (isNonTerminal(selectedChar)) {
                    updateFirstForEmptyFirst(selectedChar, i);
                    if (first[selectedChar - 'A']['^']) continue;
                } else {
                    firstEmpty[i][selectedChar] = true;
                }
                break;
            }
            if (j == productionRules[i].length) {
                firstEmpty[i]['^'] = true;
            }
        }
    }
}

void findFollowWhenConsecutiveNonTerminal(char A, char B) {  // * A->BC
    for (int i = 0; i < terminalSize; i++) {
        if (i != '^') {
            follow[B - 'A'][i] = follow[B - 'A'][i] || first[A - 'A'][i];
        }
    }
}
void findFollowWhenNonTerminalIsLast(char A, char B) {  // * A->B
    for (int i = 0; i < terminalSize; i++) {
        if (i != '^') {
            follow[B - 'A'][i] = follow[B - 'A'][i] || follow[A - 'A'][i];
        }
    }
}
void findFollow() {
    for (int t = 0; t < noOfRules; t++) {
        for (int k = 0; k < nonTerminalSize; k++) {
            if (!nonTerminals[k]) continue;
            char selectedNonTerminal = k + 'A';
            for (int i = 0; i < noOfRules; i++) {
                for (int j = 3, x = j + 1; j < productionRules[i].length; j++, x = j + 1) {
                    if (selectedNonTerminal == productionRules[i].rule[j]) {
                        for (x; x < productionRules[i].length; x++) {
                            char selectedChar = productionRules[i].rule[x];
                            if (isNonTerminal(selectedChar)) {
                                findFollowWhenConsecutiveNonTerminal(selectedChar, selectedNonTerminal);
                                if (first[selectedChar - 'A']['^']) continue;
                            } else {
                                follow[selectedNonTerminal - 'A'][selectedChar] = true;
                            }
                            break;
                        }
                        if (x == productionRules[i].length) {
                            findFollowWhenNonTerminalIsLast(productionRules[i].rule[0], selectedNonTerminal);
                        }
                    }
                }
            }
        }
    }
}

void findFirstWhenFirstIsNonTerminal(char A, char B) {
    for (int i = 0; i < terminalSize; i++) {
        if (i != '^') {
            first[B - 'A'][i] = first[A - 'A'][i] || first[B - 'A'][i];
        }
    }
}
void findFirst() {
    for (int t = 0; t < noOfRules; t++) {
        for (int i = 0, j = 3; i < noOfRules; i++, j = 3) {
            for (j; j < productionRules[i].length; j++) {
                char selectedChar = productionRules[i].rule[j];
                if (isNonTerminal(selectedChar)) {  // ? executes when selectedChar is non-terminal
                    findFirstWhenFirstIsNonTerminal(selectedChar, productionRules[i].rule[0]);
                    if (first[selectedChar - 'A']['^']) continue;   // ? ignoring epsilon in first
                } else {
                    first[productionRules[i].rule[0] - 'A'][selectedChar] = true;
                }
                break;
            }
            if (j == productionRules[i].length) {
                first[productionRules[i].rule[0] - 'A']['^'] = true;
            }
        }
    }
}

void parseTheGrammar() {
    FILE* filePointer;
    filePointer = fopen("grammar.txt", "r");
    char eachLine[255];
    while (fgets(eachLine, sizeof(eachLine), filePointer)) {
        printf("%s", eachLine);
        int j = 0;
        nonTerminals[eachLine[0] - 'A'] = true;           // * eachLine[0] => non-terminal, eachLine[0]-'A' => ASCII difference, nonTerminals[eachLine[0] - 'A'] = true means the 0-th input is non-terminal
        for (int i = 0; i < strlen(eachLine) - 1; i++) {  // ? -1 to ignore newline
            if (eachLine[i] == '|') {
                productionRules[++noOfRules - 1].rule[j] = '\0';  // ? increasing rules counter and terminating previous rule
                productionRules[noOfRules - 1].length = j;        // ? assigning length of the rule
                productionRules[noOfRules].rule[0] = productionRules[noOfRules - 1].rule[0];
                productionRules[noOfRules].rule[1] = productionRules[noOfRules - 1].rule[1];
                productionRules[noOfRules].rule[2] = productionRules[noOfRules - 1].rule[2];  // * new production rule with previous variable
                j = 3;
            } else {
                productionRules[noOfRules].rule[j++] = eachLine[i];  // * inserting the characters and counting length
                if (!isNonTerminal(eachLine[i]) && eachLine[i] != '-' && eachLine[i] != '>') {
                    terminals[eachLine[i]] = true;  // * terminals[eachLine[i]] = true means the symbol is terminal
                }
            }
        }
        productionRules[noOfRules++].length = j;
    }
}

int main(void) {
    parseTheGrammar();

    findFirst();
    follow[productionRules[0].rule[0] - 'A']['$'] = true;  // ! starting non-terminal has $
    findFollow();
    findFirstWhenFirstIsEmpty();

    printf("\n");
    for (int i = 0; i < noOfRules; i++) {  // * display first of each non-terminal
        if (i == 0 || (productionRules[i - 1].rule[0] != productionRules[i].rule[0])) {
            char c = productionRules[i].rule[0];
            printf("FIRST of %c:", c);
            for (int j = 0; j < terminalSize; j++) {
                if (first[c - 'A'][j]) {
                    printf(" %c", j);
                }
            }
            printf("\n");
        }
    }

    printf("\n");
    for (int i = 0; i < noOfRules; i++) {  // * display follow of each non-terminal
        if (i == 0 || (productionRules[i - 1].rule[0] != productionRules[i].rule[0])) {
            char c = productionRules[i].rule[0];
            printf("FOLLOW of %c:", c);
            for (int j = 0; j < terminalSize; j++) {
                if (follow[c - 'A'][j]) {
                    printf(" %c", j);
                }
            }
            printf("\n");
        }
    }

    printf("\n");
    for (int i = 0; i < noOfRules; i++) {  // * display first of each non-terminal B in form A->B
        printf("FIRST of %-10s:", productionRules[i].rule);
        for (int j = 0; j < terminalSize; j++) {
            if (firstEmpty[i][j]) {
                printf(" %c", j);
            }
        }
        printf("\n");
    }

    terminals['$'] = true;   // * the parse table contains '$' set terminals['$'] = true to include '$' in the parse table
    terminals['^'] = false;  // * the parse table doesn't contain '^' so we set terminals['^'] = false  to remove '^' from terminals

    printf("\n");
    printf("=================================================================\n");
    printf("꧁                   LL(1) Parser Table Generator              ꧂\n");
    printf("●▬▬▬▬▬▬▬▬▬▬▬▬๑۩  Code written by Sabbir & Muktadir  ۩๑▬▬▬▬▬▬▬▬▬▬●\n");
    printf("=================================================================\n");
    printf("%-10s", "NT\\T");
    for (int i = 0; i < terminalSize; i++) {
        if (terminals[i]) {
            printf("%-10c", i);
        }
    }
    for (int i = 0, p = 0; i < noOfRules; i++) {
        if (i != 0 && (productionRules[i].rule[0] != productionRules[i - 1].rule[0])) {
            p++;
        }
        for (int j = 0; j < terminalSize; j++) {
            if (firstEmpty[i][j] && j != '^') {
                table[p][j] = i + 1;
            } else if (firstEmpty[i]['^']) {
                for (int k = 0; k < terminalSize; k++) {
                    if (follow[productionRules[i].rule[0] - 'A'][k]) {
                        table[p][k] = i + 1;
                    }
                }
            }
        }
    }
    printf("\n");
    for (int i = 0, k = 0; i < noOfRules; i++) {
        if (i == 0 || (productionRules[i - 1].rule[0] != productionRules[i].rule[0])) {
            printf("%-10c", productionRules[i].rule[0]);
            for (int j = 0; j < terminalSize; j++) {
                if (table[k][j]) {
                    printf("%-10s", productionRules[table[k][j] - 1].rule);
                } else if (terminals[j]) {
                    printf("%-10s", "");
                }
            }
            k++;
            printf("\n");
        }
    }
    return 0;
}