#include<stdio.h>
int main(void)
{
    char a[100], b[100];
    int i,j,k=0;
    scanf("%[^\n]", a);
    for(i=0; a[i]!='\0'; i++);
    for(j=i-1; j>=0; j--)
    {
        b[k]=a[j];
        k++;
    }
    b[k]='\0';
    i=0;
    while(a[i]==b[i]&&a[i]!='\0'&&b[i]!='\0')
    {
        i++;
    }
    if(a[i]==b[i])
    {
        printf("Palindrome\n");
    }
    else

    {
        printf("Not Palindrome\n");
    }
    return 0;
}
