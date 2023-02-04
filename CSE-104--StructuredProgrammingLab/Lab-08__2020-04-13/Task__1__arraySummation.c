#include<stdio.h>
int main(void)
{
    int a[10][10], b[10][10],c[10][10],i,j,n,m;
    scanf("%d %d", &n, &m);
    for(i=1; i<=n; i++)
    {
        for(j=1; j<=m; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }
    for(i=1; i<=n; i++)
    {
        for(j=1; j<=m; j++)
        {
            scanf("%d", &b[i][j]);
        }
    }
    for(i=1; i<=n; i++)
    {
        for(j=1; j<=m; j++)
        {
            c[i][j]=a[i][j]+b[i][j];
        }
    }
    for(i=1; i<=n; i++)
    {
        for(j=1; j<=m; j++)
        {
            printf("%d", c[i][j]);
            if (j!=m)
            {
              printf(" ");
            }
            else
            {
              printf("\n");
            }
        }
    }
    return 0;
}
