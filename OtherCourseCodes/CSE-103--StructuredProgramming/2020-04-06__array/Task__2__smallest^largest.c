#include<stdio.h>
int main(void)
{
    int i,n, mn,mx, a[100];
    scanf("%d", &n);
    for(i=0; i<n; i++)
    {
        scanf("%d", &a[i]);
    }
    mn = a[0];
    mx = a[0];
    for(i=1; i<n; i++)
    {
        if (a[i]<mn)
        {
            mn = a[i];
        }
        if (a[i]>mx)
        {
            mx = a[i];
        }
    }
    printf("%d is lowest\n", mn);
    printf("%d is largest\n", mx);
    return 0;
}
