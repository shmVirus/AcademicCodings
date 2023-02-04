/*Program to convert Fahrenheit to Celsius*/
#include<stdio.h>
int main(void)
{
    float c,f;
    printf("Enter your Fahrenheit temperature : ");
    scanf("%f", &f);
    c = ((f-32)*5)/9;
    printf("if %.2f is Fahrenheit then %.2f is Celsius.\n", f, c);
    return 0;
}
