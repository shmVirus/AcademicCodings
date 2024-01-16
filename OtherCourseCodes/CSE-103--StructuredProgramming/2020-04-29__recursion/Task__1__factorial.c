#include <stdio.h>
int fact(int);
int main(void)
{
     int n, f;
     scanf("%d", &n);
     f = fact(n);
     printf("%d", f);
     return 0;
}

int fact(int x)
{
     int y;
     if (x != 1)
     {
          y = x * fact(x - 1);
          return y;
     }
     else
     {
          return 1;
     }
}