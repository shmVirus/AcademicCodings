/*
N x N
*****
*   *
*   *
*   *
*****
*/
#include<stdio.h>
int main(void)
{
    int a,b, n;
    scanf("%d", &n);
    for(a=1;a<=n;a++)
    {
        for(b=1;b<=n;b++)
        {
            if (a== 1 || a==n || b==1 || b==n)
            {
                printf("*");
            }
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }
    return 0;
}
