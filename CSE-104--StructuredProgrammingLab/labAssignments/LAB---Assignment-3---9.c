#include<stdio.h>
int main(void)
{
    char a;
    scanf("%c", &a);
    if (a>='A'&& a<='Z' || a>='a' && a<= 'z')
    {
        if ( a=='a' || a=='A' || a=='e' || a== 'E' || a=='i' || a=='I' || a=='o' || a=='O' || a=='u' || a=='U')
        {
            printf("%c is a Alphabet and it is a Vowel\n", a);
        }
        else
        {
            printf("%c is a Alphabet and it is a Constant\n", a);
        }
    }
    else
    {
        printf("%c is not a Alphabet\n", a);
    }
    return 0;
}
