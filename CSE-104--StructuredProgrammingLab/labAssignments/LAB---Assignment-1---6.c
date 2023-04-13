/*Program to convert Celsius to Fahrenheit*/
#include<stdio.h>
int main(void)
{
    float c,f;
    printf("Enter your Celsius temperature : ");
    scanf("%f", &c);
    f = ((c*9)/5)+32;
    printf("if %.2f is Celsius then %.2f is Fahrenheit.\n", c, f);
    return 0;
}
