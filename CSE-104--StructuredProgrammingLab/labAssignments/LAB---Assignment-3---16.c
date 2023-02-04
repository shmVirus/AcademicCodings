#include<stdio.h>
#include<math.h>
int main(void)
{
	int a,b,c, x,y;
	scanf("%d %d %d", &a, &b, &c);
	x = (-b+sqrt(pow(b,2)-4*a*c));
	y = (-b-sqrt(pow(b,2)-4*a*c));
	printf("X1 = %d & X2 = %d\n", x,y);
	return 0;
}
