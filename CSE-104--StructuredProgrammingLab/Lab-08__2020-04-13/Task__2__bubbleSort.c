#include<stdio.h>
int main(void)
{
    int a[100], i,n, j, x;
    scanf("%d",&n);
    for(i=0; i<n; i++)
    {
        scanf("%d",&a[i]);
    }
    for(i=0; i<n; i++)
    {
        for(j=0; j<n-i; j++)
        {
            if(a[j]>a[j+1])
            {
                x=a[j];
                a[j]=a[j+1];
                a[j+1]=x;
            }
        }
    }
    for(i=1; i<=n; i++)
    {
        printf("%d ",a[i]);
    }
    return 0;
}
