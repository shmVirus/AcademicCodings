/*
1
21
321
4321
54321
 */

#include<stdio.h>
int main(void)
{
    int a,b,n;
    scanf("%d", &n);
    for(a=1;a<=n;a++)
    {
        for(b=a;b>=1;b--)
        {
            printf("%d",b);
        }
        printf("\n");
    }
    return 0;
}
