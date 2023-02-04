/*
 abcde
     a
    a b
   a b c
  a b c d
 a b c d e
 */
#include<stdio.h>
int main(void)
{
    char a[30];
    int i, j, k, l;
    scanf("%[^\n]", a);
    for (i=0; a[i]!='\0'; i++);
    for (j=0; j<=i-1; j++)
    {
        for(k=0; k<i-j;k++)
	    {
	        printf(" ");

	    }
	    for(l=0;l<=j;l++)
	    {
		    printf("%c ", a[l]);
	    }
	    printf("\n");
    }
    return 0;
}
