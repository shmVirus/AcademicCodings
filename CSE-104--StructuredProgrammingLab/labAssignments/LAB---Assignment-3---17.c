#include<stdio.h>
int main(void)
{
    int i, a;
    for(i=1;i<=5;i++)
    {
        scanf("%d", &a);
        switch (a/10)
        {
            case 10:
            case 9:
                printf("Grade A\n");
                break;
            case 8:
                printf("Grade B\n");
                break;
            case 7:
                printf("Grade C\n");
                break;
            case 6:
                printf("Grade D\n");
                break;
            case 5:
            case 4:
                printf("Grade E\n");
                break;
            default:
                printf("Fail\n");

        }
    }
    return 0;
}
