#include<stdio.h>
int main(void)
{
    int a;
    scanf("%d", &a);
    switch(a)
    {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            printf("In this month we have 31 days\n");
            break;
        case 2:
            printf("In this month we have 28 or 29 days\n");
            break;
        default:
            printf("In this month we have 30 days\n");
    }
    return 0;
}
