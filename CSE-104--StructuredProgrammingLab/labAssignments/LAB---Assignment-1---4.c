/*Program to determine Area of a Rectangle*/
#include<stdio.h>
int main(void)
{
    float a,b;
    printf("Enter Length and Width of your Rectangle : ");
    scanf("%f %f", &a, &b);
    printf("%.2f is Length and %.2f is Width then %.2f is the Area.\n", a,b,a*b);
    return 0;
}
