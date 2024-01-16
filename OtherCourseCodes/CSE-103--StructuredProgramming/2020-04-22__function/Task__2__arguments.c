#include<stdio.h>
void abc(int x, int y);
int main(void)
{
    int a,b;
    scanf("%d %d", &a, &b);
    abc(a,b); // passing argument to function
    return 0;
}
void abc(int x, int y) // void=return type;
{
    int c;
    c = x+y;
    printf("%d\n", c);
}
