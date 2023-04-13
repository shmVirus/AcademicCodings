/*Program for specific area determination.*/
#include<stdio.h>
#include<math.h>
int main(void)
{
    float r, a;
    printf("Enter your Circel Radius : ");
    scanf("%f", &r);
    printf("If %.2f unit is Circle's Radius then %.2f unit is Square's Length.\n", r,  r+r);
    a = pow((r+r),2) - pow(r,2)*3.14159;
    printf("%.2f unit^2 is our expected Area which is in Square but outside of Circle.\n", a);
    return 0;
}
