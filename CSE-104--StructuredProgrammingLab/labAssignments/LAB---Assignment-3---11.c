#include<stdio.h>
int main(void)
{
    char a;
    scanf("%c", &a);
    if (a>='A'&& a<='Z' || a>='a' && a<= 'z')
    {
        if (a>='A'&& a<='Z')
        {
            printf("%c is a Alphabet it is in Uppercase\n", a);
        }
        else
        {
            printf("%c is a Alphabet it is in Lowercase\n", a);
        }
    }
    else
    {
        printf("%c is not a Alphabet\n", a);
    }
    return 0;
}
