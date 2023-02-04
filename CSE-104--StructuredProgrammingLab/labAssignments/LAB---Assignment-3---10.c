#include<stdio.h>
int main(void)
{
    char a;
    scanf("%c", &a);
    if (a>='A'&& a<='Z' || a>='a' && a<= 'z')
    {
        printf("%c is a Alphabet\n", a);
    }
    else if (a>='0' && a<='9')
    {
        printf("%c is a Digit\n", a);
    }
    else
    {
        printf("%c is a Special Character\n", a);
    }
    return 0;
}
