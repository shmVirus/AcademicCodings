/*Program for swapping values without temporary variable.*/
#include<stdio.h>
int main(void)
{
    int a, b;
    scanf("%d %d", &a, &b);
    a = a+b;
    b = a-b;
    a = a-b;
    printf("%d %d\n",a,b);
    return 0;
}
//
//
//This program can be done with multiplication.
//#include<stdio.h>
//int main(void)
//{
//    int a, b;
//    scanf("%d %d", &a, &b);
//    a = a*b;
//    b = a/b;
//    a = a/b;
//    printf("%d %d\n",a,b);
//    return 0;
//
