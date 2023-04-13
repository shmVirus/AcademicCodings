#include<stdio.h>
int main(void)
{
    int a=1,n, x=0;
    scanf("%d", &n);
    for(a;a<=n;a++)
    {
        if(a%2!=0)
        {
            x = x+a;
        }
    }
    printf("%d\n", x);
    return 0;
}

