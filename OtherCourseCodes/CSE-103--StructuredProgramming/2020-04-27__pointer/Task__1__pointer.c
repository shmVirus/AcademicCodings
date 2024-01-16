#include <stdio.h> // call by refference
void abc(int *x, int *y)
{
     *x += 10;
     *y += 10;
     printf("%d %d\n\n", *x, *y);
}
int main()
{
     int a = 10, b = 20;
     abc(&a, &b);
     printf("%d %d\n", a, b);
     return 0;
}