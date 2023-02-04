/*Program for swapping values with temporary variable.*/
#include<stdio.h>
int main(void)
{
    int a,b,c;                  // "c" is our temporary variable
    scanf("%d %d", &a, &b);
    c = a;                      // storing first value in temporary variable
    a = b;                      // swapping second value with first value
    b = c;                      // swapping first value (from temporary) with second value
    printf("%d %d\n", a,b);
    return 0;
}
