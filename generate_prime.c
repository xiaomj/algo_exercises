#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#define MAX_SIZE 1000

int v[MAX_SIZE];

void filter_out_prime(int max_num) {
	memset(v, 1, MAX_SIZE * sizeof(int));
	v[1] = 0;
	v[2] = 1;
	v[3] = 1;
	int b = sqrt((double) max_num) + 1;
	for (int i = 1; i < b; i++) {
		if (v[i]) {
			for (int j = 2; i * j < max_num; j++) {
				v[i * j] = 0;
			}
		}
	}
	for (int i = 1; i < max_num; i++) {
		if (v[i]) {
			printf("%d\n", i);
		}
	}
}

int main(int argc, char *argv) {
	filter_out_prime(500);	
}
