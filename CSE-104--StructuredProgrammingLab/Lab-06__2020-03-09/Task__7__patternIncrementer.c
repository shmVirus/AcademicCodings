/*
1
2 3
4 5 6
7 8 9 10
 */
#include<stdio.h>
int main(void)
{
    int a,b, x=1;
    for(a=1;a<=4;a++)
    {
        for(b=1;b<=a;b++)
        {
            printf("%d ",x++);
        }
        printf("\n");
    }
    return 0;
}
