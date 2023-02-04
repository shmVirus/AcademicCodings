#include<stdio.h>
int main()
{
    int a[100], i,n, j, p,s;
    scanf("%d", &n);
    for (i=0; i<n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (i=0; i<(n - 1); i++)
    {
        p = i;
        for (j=i+1; j<n; j++)
        {
            if (a[p]>a[j])
            {
                p = j;
            }
        }
        if (p!=i)
        {
            s = a[i];
            a[i] = a[p];
            a[p] = s;
        }
    }
    for (i=0; i<n; i++)
    {
        printf("%d", a[i]);
        if (i+1==n)
        {
            printf("\n");
        }
        else
        {
            printf(" ");
        }
    }
    return 0;
}
