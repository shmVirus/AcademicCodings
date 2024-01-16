#include<stdio.h>
#include<string.h>
int main(void)
{
    int i, v=0, c=0, d=0, s=0;
    char a[200];
    scanf("%[^\n]",a);
    for(i=0; a[i]!='\0'; i++)
    {
        if (a[i]>=65 && a[i]<=90 || a[i]>=97 && a[i]<=122)
        {
            if (a[i] == 'a' || a[i]=='e' || a[i]=='i' || a[i]=='o' || a[i]=='u' || a[i]=='A' || a[i]=='E' || a[i]=='I' || a[i]=='O' || a[i]=='U')
            {
                v++;
            }
            else
            {
                c++;
            }
        }
        else if (a[i]>=48 && a[i]<=57)
        {
            d++;
        }
        else
        {
            s++;
        }
    }
    printf("%d Digits\n%d Vowels\n%d Consonants\n%d Special Characters\n", d,v,c,s);
    return 0;
}
