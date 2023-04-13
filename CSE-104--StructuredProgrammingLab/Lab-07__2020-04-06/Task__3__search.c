#include<stdio.h>
int main(void)
{
    int i,n, m,c=0, a[100];
    scanf("%d", &n);
    for(i=0; i<n; i++)
    {
        scanf("%d", &a[i]);
    }
    scanf("%d", &m);
    for(i=0; i<n; i++)
    {
        if(m==a[i])
        {
            c++;
        }
    }
    if(c!=0)
    {
        printf("Found\n");
    }
    else
    {
        printf("Not Found\n");
    }
    return 0;
}
