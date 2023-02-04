/*Program for average of 5 inputs*/
#include<stdio.h>
int main(void)
{
    float a,b,c,d,e, r;
    printf("Enter your Numbers in Subjects : ");
    scanf("%f %f %f %f %f", &a, &b, &c, &d, &e);
    r = (a+b+c+d+e)/5;
    printf("If 1st Number is %.2f\n", a);
    printf("If 2nd Number is %.2f\n", b);
    printf("If 3rd Number is %.2f\n", c);
    printf("If 4th Number is %.2f\n", d);
    printf("If 5th Number is %.2f\n", e);
    printf("Then Average of these Numbers is %.2f\n", r);
}
