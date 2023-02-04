#include<stdio.h>
int main(void)
{
    int a,b,c;
    scanf("%d %d %d", &a, &b, &c);
    switch(a+b+c)
    {
        case 180:
            printf("triangle is valid\n");
            break;
        default:
            printf("triangle is not valid\n");
    }
    return 0;
}
