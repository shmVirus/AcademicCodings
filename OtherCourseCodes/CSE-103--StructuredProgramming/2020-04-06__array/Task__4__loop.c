#include<stdio.h>
int main(void)
{
    int a[100],i,n,m;
    scanf("%d", &n);
    for(i=1; i<=n; i++)
        scanf("%d", &a[i]);
    for(i=1; i<=n; i++)
        printf("%d",a[i]);
    printf("\n");
    for(i=n; i>=1; i--)
        printf("%d",a[i]);
    return 0;
}
