#include<stdio.h>
int main() {
    int n, l=0, r;
    scanf("%d", &n);
    while(n!=0) {
        r = n % 10;
        l += r;
        n /= 10;
        if (n==0) printf("%d\n", l);
        if (l>9 && n==0) {
            n = l;
            l = 0;
        }
    }
    return 0;
}