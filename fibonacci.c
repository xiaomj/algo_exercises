#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int fibonacci(int n) {
	int a = 0;
	int b = 1;
	if (n == 1) {
		return a;
	}
	if (n == 2) {
		return b;
	}
	int c = 1;
	while (n > 3) {
		int t = b + c;
		a = b;
		b = c;
		c = t;
		n--;
	}
	return c;
}

int main(int argc, char *argv[]) {
	printf("%d\n", fibonacci(10));	
}
