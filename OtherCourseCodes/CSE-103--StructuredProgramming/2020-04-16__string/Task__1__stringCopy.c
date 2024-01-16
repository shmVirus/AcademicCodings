#include<stdio.h>
#include<string.h>
int main(void)
{
    int i;
    char a[20], b[20];
    scanf("%[^\n]",a);
    for(i=0; a[i]!='\0'; i++)
    {
        b[i]=a[i];
    }
    b[i]='\0';
    printf("%s", b);
    return 0;
}
