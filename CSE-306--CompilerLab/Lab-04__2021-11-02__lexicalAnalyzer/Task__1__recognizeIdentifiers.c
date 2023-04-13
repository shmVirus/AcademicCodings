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
bool isValidIdentifier(char* str) {
    if (str[0] == '0' || str[0] == '1' || str[0] == '2' ||
        str[0] == '3' || str[0] == '4' || str[0] == '5' ||
        str[0] == '6' || str[0] == '7' || str[0] == '8' ||
        str[0] == '9' || isValidDelimiter(str[0]) == true) {
        return (false);
    }
    return (true);
}
char* subString(char* str, int left, int right) {
    int i;
    char* subStr = (char*)malloc(sizeof(char) * (right - left + 1));
    for (i = left; i <= right; i++) {
        subStr[i - left] = str[i];
    }
    subStr[right - left + 1] = '\0';
    return (subStr);
}
void detectTokens(char* str) {
    int left = 0, right = 0;
    int length = strlen(str);
    while (right <= length && left <= right) {
        if (isValidDelimiter(str[right]) == false) {
            right++;
        }
        if (isValidDelimiter(str[right]) == true && left == right) {
            right++;
            left = right;
        } else if (isValidDelimiter(str[right]) == true && left != right || (right == length && left != right)) {  //?
            char* subStr = subString(str, left, right - 1);
            if (isValidIdentifier(subStr) == true && isValidDelimiter(str[right - 1]) == false) {
                printf("\tValid Identifier\t: '%s'\n", subStr);
            } else if (isValidIdentifier(subStr) == false && isValidDelimiter(str[right - 1]) == false) {
                printf("\tInvalid Identifier\t: '%s'\n", subStr);
            }
            left = right;
        }
    }
    return;
}
int main(void) {
    char str[100] = "float x = a + 1b;";
    printf("The Program is\t: '%s'\n", str);
    printf("All Tokens are\t: \n");
    detectTokens(str);
    return (0);
}