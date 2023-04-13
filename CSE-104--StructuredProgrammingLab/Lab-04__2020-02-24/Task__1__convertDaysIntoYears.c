/*Program for converting days into years, months, weeks*/
#include<stdio.h>
int main(void)
{
    int A, a,b,c,d;
    scanf("%d", &A);
    a = A/365; // Calculating years
    printf("%d Years\n", a);
    b = A%365/30; // Calculating months
    printf("%d Months\n", b);
    c = A%365%30/7; // Calculating weeks
    printf("%d Weeks\n", c);
    d = A%365%30%7; // Calculating Reaming Days
    printf("%d Days\n", d);
    return 0;
}
