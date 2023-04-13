/*Program to determine big number between two inputs*/
#include<stdio.h>
int main(void)
{
    float a,b;
    printf("Enter numbers to find maximum : ");
    scanf("%f %f", &a, &b);
    if (a>b)
    {
        printf("%.2f is the maximum value between %.2f and %.2f\n", a, a, b);
    }
    else if ( a==b )
    {
        printf("both are equal between %.2f and %.2f\n", a, b);
    }
    else
    {
        printf("%.2f is the maximum value between %.2f and %.2f\n", b, a, b);
    }
    return 0;
}
