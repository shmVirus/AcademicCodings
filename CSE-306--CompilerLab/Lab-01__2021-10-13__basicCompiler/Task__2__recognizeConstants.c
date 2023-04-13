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
bool isValidInteger(char* string) {
    int i, len = strlen(string);
    if (len == 0) {
        return (false);
    }
    for (i = 0; i < len; i++) {
        if (string[i] != '0' && string[i] != '1' && string[i] != '2' && string[i] != '3' &&
                string[i] != '4' && string[i] != '5' && string[i] != '6' && string[i] != '7' &&
                string[i] != '8' && string[i] != '9' ||
            (string[i] == '-' && i > 0)) {
            return (false);
        }
    }
    return (true);
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
            if (isValidInteger(subString) == true) {
                printf("\tValid Constant\t\t: '%s'\n", subString);
            }
            left = right;
        }
    }
    return;
}
int main(void) {
    char string[100] = "float x = 5 + 1b;";
    printf("The Program is\t: '%s'\n", string);
    printf("All Tokens are\t: \n");
    detectTokens(string);
    return (0);
}