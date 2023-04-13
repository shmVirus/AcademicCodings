#include<stdio.h>
int main(void)
{
    int i,n,m, a[100];
    scanf("%d", &n);
    for(i=0; i<n; i++)
    {
        scanf("%d", &a[i]);
    }
    m = a[0];
    for(i=1; i<n; i++)
    {
        if (a[i]<m)
        {
            m = a[i];
        }
    }
    printf("%d is lowest\n", m);
    return 0;
}
