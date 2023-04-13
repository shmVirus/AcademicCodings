#include<stdio.h>
int main(void)
{
    char x, y;
a:
    scanf("%c", &x);
    if (x>=65 && x<=90 || x>=97 && x<=122)
    {
        if (x>=97 && x<=109)
        {
            y = 122;
            y = y - (x-97);
        }
        if (x>=110 && x<=122)
        {
            y = 110;
            y = y - (x-109);
        }
        if (x>=65 && x<= 77)
        {
            y = 90;
            y = y - (x-65);
        }
        if (x>=78 && x<=90)
        {
            y = 78;
            y = y - (x-77);
        }
    }
    else
    {
        goto a;
    }
    printf("%Your input '%c' converted to our output '%c'\n",x,y);
    return 0;
}
