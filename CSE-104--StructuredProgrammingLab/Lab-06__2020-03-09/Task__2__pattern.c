/*
1
12
123
1234
12345
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
            printf("%d",b);
        }
        printf("\n");
    }
    return 0;
}
