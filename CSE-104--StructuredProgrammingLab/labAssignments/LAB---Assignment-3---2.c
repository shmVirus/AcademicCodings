/*Program to determine big number between two inputs*/
#include<stdio.h>
int main(void)
{
    float a,b,c;
    printf("Enter numbers to find maximum : ");
    scanf("%f %f %f", &a, &b, &c);
    if (a>b && a>c)
    {
        printf("%.2f is the maximum value between %.2f, %.2f and %.2f\n", a, a, b, c);
    }
    if (b>a && b>c)
    {
        printf("%.2f is the maximum value between %.2f, %.2f and %.2f\n", b, a, b, c);
    }
    if ( c>a && c>b)
    {
        printf("%.2f is the maximum value between %.2f, %.2f and %.2f\n", c, a, b, c);
    }
    return 0;
}
