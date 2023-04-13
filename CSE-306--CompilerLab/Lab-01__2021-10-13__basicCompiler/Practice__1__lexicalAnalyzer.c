#include <ctype.h>
#include <stdio.h>
#include <string.h>

void check_keyword(char str[10]) {
    if (strcmp("int", str) == 0 || strcmp("float", str) == 0 || strcmp("for", str) == 0 | strcmp("do", str) == 0 || strcmp("while", str) == 0 || strcmp("return", str) == 0 || strcmp("continue", str) == 0 || strcmp("main", str) == 0) {
        printf("\n %s is a keyword", str);
    } else {
        printf("\n%s is an Identifier", str);
    }
}

int main(void) {
    FILE *input_file, *keywordId_file, *specialChar_file;
    char c, str[10];
    int tokenvalue = 0, num[100], i = 0, j = 0, k = 0, lineno;

    printf("\n Enter your Program\n");
    input_file = fopen("input.txt", "w");

    while ((c = getchar()) != EOF) {
        putc(c, input_file);
    }

    fclose(input_file);

    input_file = fopen("input.txt", "r");
    keywordId_file = fopen("keywordId", "w");
    specialChar_file = fopen("specialChar", "w");

    while ((c = getc(input_file)) != EOF) {
        if (isdigit(c)) {
            tokenvalue = c - '0';  // 1*10 + 1
            c = getc(input_file);
            while (isdigit(c)) {
                tokenvalue = (10 * tokenvalue) + c - '0';
                c = getc(input_file);
            }
            num[i++] = tokenvalue;
            ungetc(c, input_file);
        } else {
            if (isalpha(c)) {
                putc(c, keywordId_file);
                c = getc(input_file);
                while (isdigit(c) || isalpha(c) || c == '_' || c == '$') {
                    putc(c, keywordId_file);
                    c = getc(input_file);
                }
                putc(' ', keywordId_file);
                ungetc(c, input_file);
            } else {
                if (c == ' ' || c == '\t') {
                    printf("Blank ");
                } else {
                    if (c == '\n') {
                        lineno++;
                    } else {
                        putc(c, specialChar_file);
                    }
                }
            }
        }
    }

    fclose(input_file);
    fclose(keywordId_file);
    fclose(specialChar_file);

    printf("\n Number of Line: %d", lineno);
    printf("\n Digit : ");
    for (j = 0; j < i; j++) {
        printf("%d ", num[j]);
    }
    printf("\n");

    printf("Keyword and Identifier: ");
    keywordId_file = fopen("keywordId", "r");

    while ((c = getc(keywordId_file)) != EOF) {
        if (c != ' ') {
            str[k++] = c;
        } else {
            str[k] = '\0';
            check_keyword(str);
            k = 0;
        }
    }
    fclose(keywordId_file);
    return 0;
}
