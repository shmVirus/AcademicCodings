#include<stdio.h>
#include<string.h>
int main(void)
{
    int i,j;
    char a[20], b[20];
    scanf("%[^\n] %[^\n]",a,b);
    for(i=0; a[i]!='\0'; i++);
    for(j=0; b[j]!='\0'; j++)
    {
        a[i] = b[j];
        i++;
    }
    a[i] = '\0';
    printf("%s", a);
    return 0;
}
