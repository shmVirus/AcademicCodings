/*
12345
1234
123
12
1
 */

#include<stdio.h>
int main(void)
{
    int a=1,b,n;
    scanf("%d", &n);
    for(n;n>=a;n--)
    {
        for(b=1;b<=n;b++)
        {
            printf("%d",b);
        }
        printf("\n");
    }
    return 0;
}
