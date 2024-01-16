#include<stdio.h>
void abc(); // declaration
int main(void)
{
    abc(); // calling
    return 0;
}
void abc() // definition
{
    int a,b;
    scanf("%d %d", &a, &b);
    printf("%d\n", a+b);
}
