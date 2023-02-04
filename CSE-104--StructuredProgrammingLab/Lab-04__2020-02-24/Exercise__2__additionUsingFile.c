#include <stdio.h>
int main(void) {
	int M,N, i=0, a=0;
	freopen("Exercise__2__input.txt","r", stdin);
	freopen("Exercise__2__output.txt","w", stdout);
	while(scanf("%d %d", &M, &N)!=EOF) {
	    if (M<=0 || N<=0) {
            break;
        }
        if (M>N) {
            M = M+N;
            N = M-N;
            M = M-N;
        }
        for (M;M<=N;M++) {
	        printf("%d ", M);
		    a = a + M;
	    }
	    printf("Sum=%d\n", a);
    }
	return 0;
}
