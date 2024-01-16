#include<stdio.h>
int main(void)
{
    int i=0,j,n, a[100];
    scanf("%d", &n);
    while(n!=0)
    {
        a[i]=n%2;
        n/=2;
        i++;
    }
    for(j=i-1; j>=0; j--)
    {
        printf("%d", a[j]);
        if (j==0)
        {
            printf("\n");
        }
    }
    return 0;
}
