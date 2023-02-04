#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

bool isValidDelimiter(char ch) {
    if (ch == ' ' || ch == '+' || ch == '-' || ch == '*' ||
        ch == '/' || ch == ',' || ch == ';' || ch == '>' ||
        ch == '<' || ch == '=' || ch == '(' || ch == ')' ||
        ch == '[' || ch == ']' || ch == '{' || ch == '}') {
        return (true);
    }
    return (false);
}

bool isValidIdentifier(char* string) {
    if (string[0] == '0' || string[0] == '1' || string[0] == '2' ||
        string[0] == '3' || string[0] == '4' || string[0] == '5' ||
        string[0] == '6' || string[0] == '7' || string[0] == '8' ||
        string[0] == '9' || isValidDelimiter(string[0]) == true) {
        return (false);
    }
    return (true);
}

bool isValidKeyword(char* string) {
    if (!strcmp(string, "if") || !strcmp(string, "else") || !strcmp(string, "while") ||
        !strcmp(string, "do") || !strcmp(string, "break") || !strcmp(string, "continue") ||
        !strcmp(string, "int") || !strcmp(string, "double") || !strcmp(string, "float") ||
        !strcmp(string, "return") || !strcmp(string, "char") || !strcmp(string, "case") ||
        !strcmp(string, "char") || !strcmp(string, "sizeof") || !strcmp(string, "long") ||
        !strcmp(string, "short") || !strcmp(string, "typedef") || !strcmp(string, "switch") ||
        !strcmp(string, "unsigned") || !strcmp(string, "void") || !strcmp(string, "static") ||
        !strcmp(string, "struct") || !strcmp(string, "goto")) {
        return (true);
    }
    return (false);
}

char* getSubString(char* string, int left, int right) {
    int i;
    char* subString = (char*)malloc(sizeof(char) * (right - left + 1));
    for (i = left; i <= right; i++) {
        subString[i - left] = string[i];
    }
    subString[right - left + 1] = '\0';
    return (subString);
}

void detectTokens(char* string) {
    int left = 0, right = 0;
    int length = strlen(string);
    while (right <= length && left <= right) {
        if (isValidDelimiter(string[right]) == false) {
            right++;
        }
        if (isValidDelimiter(string[right]) == true && left == right) {
            right++;
            left = right;
        } else if (isValidDelimiter(string[right]) == true && left != right || (right == length && left != right)) {  //?
            char* subString = getSubString(string, left, right - 1);
            if (isValidKeyword(subString) == true) {
            } else if (isValidIdentifier(subString) == true && isValidDelimiter(string[right - 1]) == false) {
                printf("\tValid Identifier\t: '%s'\n", subString);
            } else if (isValidIdentifier(subString) == false && isValidDelimiter(string[right - 1]) == false) {
                printf("\tInvalid Identifier\t: '%s'\n", subString);
            }
            left = right;
        }
    }
    return;
}

int main(void) {
    char string[100] = "float x = a + 1b;";
    printf("The Program is\t: '%s'\n", string);
    printf("All Tokens are\t: \n");
    detectTokens(string);
    return (0);
}