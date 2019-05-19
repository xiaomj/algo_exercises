#include <stdio.h>
#include <stdlib.h>
#include <string.h>

bool equal(double a, double b) {
	if (a - b < 0.0000001 && a - b > -0.0000001) {
		return true;
	}
}

double my_pow(double base, int exponent) {
	// 考虑base为0的情况
	if (equal(base, 0.0)) {
		return 0;
	}
	
	int lt_one = 0;
	// 这里考虑到溢出情况
	if (exponent == INT_MIN) {
		return 0;
	}
	if (exponent < 0) {
		lt_one = 1;
		exponent = -exponent;
	}
	double sum = 1;
	while (exponent--) {
		sum = sum * base;
	}
	if (lt_one) {
		return 1.0 / sum;
	}
	return sum;
}

int main(int argc, char *argv[]) {
	printf("%lf\n", my_pow(2, -10));	
}
