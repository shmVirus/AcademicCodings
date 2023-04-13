#include<stdio.h>
int main(void)
{
    float a;
    printf("Enter numbers to check negative, positive or zero : ");
    scanf("%f", &a);
    if (a>0)
    {
        printf("%.2f is a Positive number.\n",a);
    }
    if (a<0)
    {
        printf("%.2f is a Negative number.\n",a);
    }
    if (a==0)
    {
        printf("%.2f is a Neutral number that is it is zero.\n",a);
    }
    return 0;
}
