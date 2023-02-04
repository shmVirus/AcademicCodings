#include<stdio.h>
int main(void)
{
    char a[1000];
    int i, w=0;
    scanf("%[^\n]", a);
    for(i=0; a[i]!='\0'; i++)
    {
        if (a[i]==' ' || a[i]=='.')
        {
            w++;
        }
    }
    printf("%d words in the sentence\n", w);
    return 0;
}
