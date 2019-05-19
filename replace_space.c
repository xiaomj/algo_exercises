#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void replace_space(char *src, char *dst) {
	int i = 0;
	int j = 0;
	while (src[i]) {
		if (src[i] == ' ') {
			dst[j++] = '%';
			dst[j++] = '2';
			dst[j++] = '0';
		} else {
			dst[j++] = src[i];
		}
		i++;
	}
	dst[j] = '\0';
}

// src非常长，原地替换
void replace_space_v2(char *src) {
	int i = 0;
	int count_of_space = 0;
	while (src[i]) {
		if (src[i] == ' ') {
			count_of_space++;
		}
		i++;
	}
	int len_of_newstr = strlen(src) + count_of_space * 2;
	i = strlen(src) - 1;
	int j = len_of_newstr - 1;
	while (i >= 0) {
		if (src[i] == ' ') {
			src[j--] = '0';
			src[j--] = '2';
			src[j--] = '%';
		} else {
			src[j--] = src[i];
		}
		i--;
	}
	src[len_of_newstr] = '\0';
}

int main(int argc, char *argv[]) {
	char src[1000] = "we are happy.";
	char dst[1000] = "test";
	replace_space_v2(src);
	printf("%s\n", src);
}
