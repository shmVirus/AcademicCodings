#include<stdio.h>
int main(void)
{
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);
    if  (a+b>c || a+c>b || b+c>a)
    {
            if (a==b && b==c)
            {
                printf("Triangle is Equilateral\n");
            }
            else if (a==b || b==c || a==c)
            {
                printf("Triangle is Isosceles\n");
            }
            else
            {
                printf("Triangle is Scalene\n");
            }
    }
    else
    {
        printf("triangle is not valid\n");
    }
    return 0;
}
