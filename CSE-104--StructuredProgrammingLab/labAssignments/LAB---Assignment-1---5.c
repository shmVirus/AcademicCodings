/*Program to determine Area of a Square*/
#include<stdio.h>
#include<math.h>
int main(void)
{
    float r;
    printf("Enter Length of your Square : ");
    scanf("%f", &r);
    printf("If %.2f unit is Length of your Square then %.2f unit is Square's Area.\n", r, pow(r,2));
    return 0;
}
