/*Program for scanning and printing multiple data.*/
#include<stdio.h>
int main(void)
{
    int a,b;                    // "int" is the "keyword" and "a", "b" is the "identifier" for integer data type.
    scanf("%d %d", &a, &b);     // "scanf" is the function for scanning and "%d" is the "specifier" for integer data type.
    printf("%i %i\n",a, b);     // "printf" is the function for printing. Integer has one more "specifier" that is "%i".
    return 0;
}
