/*
1
22
333
4444
55555
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
            printf("%d",a);
        }
        printf("\n");
    }
    return 0;
}
