#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int hw[100][100];

void calc(char *src) {
	int maxi = 0;
	int maxj = 0;
	for (int i = 0; i < strlen(src); i++) {
		hw[i][i] = 1;
	}

	for (int len = 1; len < strlen(src); len++) {
		for (int i = 0; i + len < strlen(src); i++) {
			if (src[i] == src[i+len]) {
				if (len == 1 || hw[i+1][i+len-1] == 1) {
					hw[i][i+len] = 1;
					if (len > maxj - maxi) {
						maxi = i;
						maxj = len + i;
					}
				}
			}
		}
	}
	while (maxi <= maxj) {
		printf("%c", src[maxi++]);
	}
	printf("\n");
}

int main(int argc, char **argv) {
	calc("abcce");
}
