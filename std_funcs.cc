#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include <stack>

void my_strcpy(char *src, char *dst) {
	if (!src || !dst) {
		return;
	}
	// 假设src，dst都是合法的字符串
	int i = 0;
	while (dst[i]) {
		src[i] = dst[i];
		i++;
	}	
}

int my_strcmp(char *src, char *dst) {
	if (!src || !dst) {
		return 1;
	}
	int i = 0;
	while (src[i] && dst[i]) {
		if (src[i] < dst[i]) {
			return -1;
		} else if (src[i] > dst[i]) {
			return 1;
		}
		i++;
	}
	if (src[i]) {
		return 1;
	}
	if (dst[i]) {
		return -1;
	}
	return 0;
}

//  只考虑十进制
int my_atoi(char *src) {
	int i = 0;
	// 检查空串
	if (!src) {
		return 0;
	}
	// 处理负号
	int minus = 1;
	if (src[i] == '-') {
		i++;
		minus = -1;
	}
	int sum = 0;
	while (src[i]) {
		if (src[i] <= '9' && src[i] >= '0') {
			sum = (src[i] - '0') + sum * 10;
			// 处理溢出
			if (sum < 0) {
				return -1;
			}
		} else {
			// 如果不是合法字符，就直接返回
			break;
		}
		i++;
	}
	return sum * minus;
}

void swap(char *src, int a, int b) {
	int t = src[a];
	src[a] = src[b];
	src[b] = t;
}

void my_itoa(int src, char *dst) {
	// 处理最小值
	if (src == INT_MIN) {
		strcpy(dst, "-2147483648");
		return;
	}
	int j = 0;
	if (src < 0) {
		dst[j++] = '-';
		src = -src;
	}

	std::stack<char> tmp;
	while (src != 0) {
		tmp.push(src % 10 + '0');
		src = src / 10;
	}
	while (!tmp.empty()) {
		dst[j++] = tmp.top();
		tmp.pop();
	}
}

int main(int argc, char *argv[]) {
	char dst[100];
	memset(dst, 0, sizeof(dst));
	my_itoa(INT_MIN, dst);
	printf("%s\n", dst);
	//printf("%d\n", my_strcmp("0123", "123"));
	//printf("%d\n", my_strcmp("", "123"));
	//printf("%d\n", my_strcmp(NULL, "123"));
}
