#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int frog_jump(int n) {
	int a, b, c;
	a = 0;
	b = 1;
	c = 1;
	for (int i = 3; i <= n; i++) {
		int t = b + c;
		a = b;
		b = c;
		c = t;
	}
	return c;		
}

int main(int argc, char *argv[]) {
	printf("%d\n", frog_jump(10));	
}
