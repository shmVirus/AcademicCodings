#include<stdio.h>
int main(void)
{
    int i,n, s=0, a[100];
    float avg;
    scanf("%d", &n);
    for(i=0; i<n; i++)
    {
        scanf("%d", &a[i]);
    }
    for(i=0; i<n; i++)
    {
        s+=a[i];
    }
    avg = (float)s/n;
    printf("%.2f is Average\n", avg);
    return 0;
}
