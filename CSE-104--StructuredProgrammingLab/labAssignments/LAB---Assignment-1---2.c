/*Program to determine Circumference and Area of Circle*/
#include<stdio.h>
#include<math.h>
int main(void)
{
    float r, a, s;
    printf("Enter your Circle Radius : ");
    scanf("%f", &r);
    a = pow(r,2)*3.14159;
    s = 2*3.14159*r;
    printf("If %.2f is Circle's Radius\nthen %.2f is Circumference and %.2f is Area of that Circle.\n", r, s, a);
    return 0;
}
