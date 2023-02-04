#include<stdio.h>
int main(void)
{
    int i=1;
    float a, x;
    for(i;i<=3;i++)
    {
        scanf("%f", &a);
        if (a>0 && a<=10000)
        {
            x = a+((a*20)/100)+((a*80)/100);
        }
        if (a>10000 && a<=20000)
        {
            x = a+((a*25)/100)+((a*90)/100);
        }
        if (a>20000)
        {
            x = a+((a*30)/100)+((a*95)/100);
        }
        printf("%.2f\n", x);
    }
    return 0;
}
