/*
1
10
101
1010
10101
 */
#include<stdio.h>
int main(void)
{
    int a,b,n;
    scanf("%d", &n);
    for(a=1;a<=n;a++)
    {
        for(b=1;b<=a;b++)
        {
            printf("%d",b%2);
        }
        printf("\n");
    }
    return 0;
}
