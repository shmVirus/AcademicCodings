/*Program to convert Centimeter to Meter and KiloMeter*/
#include<stdio.h>
int main(void)
{
    float c, m, k;
    printf("Enter your length is centimeter : ");
    scanf("%f", &c);
    m = c/100;
    k = c/100000;
    printf("%.3f centimeter = %.3f meter or %.3f kilometer.\n", c,m,k);
    return 0;
}
