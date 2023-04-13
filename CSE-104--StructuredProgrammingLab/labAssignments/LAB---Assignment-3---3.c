/*Program to check Even or Odd*/
#include<stdio.h>
int main(void)
{
    int a;
    printf("Enter number to find Even or Odd : ");
    scanf("%d", &a);
    if (a%2==0)
    {
        printf("%d is a Even number.\n",a);
    }
    else
    {
        printf("%d is a Odd number.\n",a);
    }
    return 0;
}
