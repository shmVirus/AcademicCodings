#include<stdio.h>
int abc();
int main(void)
{
    int c;
    c = abc();
    printf("%d\n", c);
    return 0;
}
int abc()
{
    int a,b,c;
    scanf("%d %d", &a, &b);
    c = a+b;
    return c;
}
