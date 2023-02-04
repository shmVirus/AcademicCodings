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
bool isValidInteger(char* str) {
    int i, len = strlen(str);
    if (len == 0) {
        return (false);
    }
    for (i = 0; i < len; i++) {
        if (str[i] != '0' && str[i] != '1' && str[i] != '2' && str[i] != '3' &&
                str[i] != '4' && str[i] != '5' && str[i] != '6' && str[i] != '7' &&
                str[i] != '8' && str[i] != '9' ||
            (str[i] == '-' && i > 0)) {
            return (false);
        }
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
            if (isValidInteger(subStr) == true) {
                printf("\tValid Constant\t\t: '%s'\n", subStr);
            }
            left = right;
        }
    }
    return;
}
int main(void) {
    char str[100] = "float x = 5 + 1b;";
    printf("The Program is\t: '%s'\n", str);
    printf("All Tokens are\t: \n");
    detectTokens(str);
    return (0);
}