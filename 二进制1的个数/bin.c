#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

// 这个函数有问题的
// 如果是负数，结果是错误的
int bin(int in) {
	if (in == INT_MIN) {
		return 32;
	}
	if (in < 0) {
		in = -in;
	}
	int num = 0;
	while (in) {
		num += in & 1;
		in = in >> 1;
	}
	return num;
}

int bin_right(int in) {
	unsigned int flag = 1;
	int num = 0;
	while (flag) {
		if (flag & in) {
			num++;
		}
		flag = flag << 1;
	}
	return num;	
}

int main(int argc, char **argv) {
	printf("%d\n", bin_right(0xf111));
}
