#include<stdio.h>
int main(void)
{
    int a,n,x=0;
    scanf("%d", &n);
    while(n!=0)
    {
        a = n%10;
        n = n/10;
        x = x + a;
    }
    printf("%d",x);
}
