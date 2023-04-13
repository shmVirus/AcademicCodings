#include<stdio.h>
int main(void)
{
    char a;
    scanf("%c", &a);
    if (a>='A'&& a<='Z' || a>='a' && a<= 'z')
    {
        printf("%c is a Alphabet\n", a);
    }
    else
    {
        printf("%c is not a Alphabet\n", a);
    }
    return 0;
}
