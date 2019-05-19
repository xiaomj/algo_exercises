#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compare_two_number(char *a, char *b) {
	if (!a || !b) {
		return -2;
	}
	int i = 0;
	int j = 0;
	bool minus_a = 0;
	bool minus_b = 0;

	// 处理正负号
	if (a[0] == '-') {
		minus_a = 1;
		i++;
	}
	if (a[0] == '+') {
		minus_a = 0;
		i++;
	}
	
	if (b[0] == '-') {
		minus_b = 1;
		j++;
	}
	if (b[0] == '+') {
		minus_b = 0;
		j++;
	}
	
	// 处理前缀0
	while (a[i] == '0') {
		i++;
	}
	while (b[j] == '0') {
		j++;
	}
	
	// 计算小数点
	int dot_a = strstr(a, ".");
	if (dot_a == -1) {
		dot_a = strlen(a);
	}
	int dot_b = strstr(b, ".");
	if (dot_b == -1) {
		dot_b = strlen(b);
	}
	
	// 比较整数部分
	int len_integer_a = dot_a - i;
	int len_integer_b = dot_b - j;
	
	// 比较小数部分
	substr(a, strstr(a, "."));
	substr(b, strstr(b, "."));
	
	//总的比较逻辑
	//1. 考虑都是0
	//2. 正负数
	if (minus_a) {
	}
	//3.都是正数
	
	//4.都是负数
}

int main(int argc, char *argv[]) {
}
