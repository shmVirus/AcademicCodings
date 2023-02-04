#include<stdio.h>
int main(void)
{
    char a[1000];
    int i;
    scanf("%[^\n]", a);
    for(i=0; a[i]!='\0'; i++)
    {
        if (a[i]==' ')
        {
            if (a[i+1]>=90 && a[i+1]<=122)
            {
                a[i+1]= a[i+1]-32;
                i--;
            }
        }
    }
    if (a[0]>=90 && a[i]<=122)
    {
        a[0]= a[0]-32;
    }
    printf("%s\n", a);
    return 0;
}
