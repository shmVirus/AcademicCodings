#include<stdio.h>
int abc(int x, int y);
int main(void)
{
    int a,b,z;
    scanf("%d %d", &a, &b);
    z = abc(a,b); // passing argument to function
    printf("%d\n", z);
    return 0;
}
int abc(int x, int y)
{
    int c;
    c = x+y;
    return c; // returning value to the main fucntion
}
