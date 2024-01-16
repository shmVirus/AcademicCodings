#include <stdio.h>
int abc(int);
int main(void)
{
     int n;
     scanf("%d", &n);
     abc(n);
     return 0;
}

int abc(int x)
{
     printf("%d\n", x);
     if (x != 1)
     {
          abc(x - 1);
     }
}