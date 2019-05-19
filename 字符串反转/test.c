#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void internal_reverse(char *src, int i, int j) {
	while (i < j && j < strlen(src)) {
		char t = src[i];
		src[i] = src[j];
		src[j] = t;
		i++;
		j--;
	}
}

void reverse(char *src) {
	internal_reverse(src, 0, strlen(src) - 1);
	
	int start = 0;
	int end = 0;
	int i = 0;
	for (i = 0; i < strlen(src); i++) {
		while (i < strlen(src) && src[i] == ' ') {
			i++;
		}
		start = i;
		while (i < strlen(src) && src[i] != ' ') {
			i++;
		}
		end = i - 1;
		internal_reverse(src, start, end);
	}
	printf("%s\n", src);
}

int main(int argc, char **argv) {
	char src[] = "abc ab ce";
	reverse(src);
}
