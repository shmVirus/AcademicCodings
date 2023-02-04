/*Program to check a year Leap year or not*/
#include<stdio.h>
int main(void)
{
    int a;
    printf("Enter Year to check Leap year or not : ");
    scanf("%d", &a);
    if(a%4==0)
    {
        printf("%d is a Yeap year.\n", a);
    }
    else
    {
        printf("%d is not a Yeap year.\n", a);
    }
    return 0;
}
