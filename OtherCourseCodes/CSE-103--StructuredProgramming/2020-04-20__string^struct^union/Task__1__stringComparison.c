#include<stdio.h>
int main(void)
{
    char a[100], b[100];
    int i=0;
    scanf("%[^\n] %[^\n]", a, b);
    while(a[i]==b[i]&&a[i]!='\0'&&b[i]!='\0')
    {
        i++;
    }
    if(a[i]==b[i])
    {
        printf("Same\n");
    }
    else

    {
        printf("Different\n");
    }
    return 0;
}
