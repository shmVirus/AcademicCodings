/*Program for basic arithmetic operation*/
#include<stdio.h>
int main(void)
{
    int a,b, w,x,y,z;
    scanf("%d %d", &a, &b);
    w = a+b;
    x = a-b;
    y = a*b;
    z = a/b;
    printf("Sum is %d\n", w);
    printf("Sub is %d\n", x);
    printf("Mul is %d\n", y);
    printf("Div is %d\n", z);
    return 0;
}
