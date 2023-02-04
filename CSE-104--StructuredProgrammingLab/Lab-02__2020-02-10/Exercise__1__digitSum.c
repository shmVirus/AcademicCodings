/*Program for digit sum between three files.*/
#include<stdio.h>
int main(void)
{
    int a, b, c, d, x;
    scanf("%d", &a);
    b = a/100;          // to find first digit value
    c = (a-b*100)/10;   // to find second digit value
    d = a%10;           // to find third digit value
    x = b+c+d;
    printf("%d", x);
    return 0;
}
