#include<stdio.h>
int main(void)
{
    int a=1, n;
    scanf("%d", &n);
    for(a;a<=10;a++)
    {
        printf("%d * %d = %d\n", n,a, n*a);
    }
}
