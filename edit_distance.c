#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 100

int min(int a, int b, int c) {
	return a > b ? (b > c ? c : b) : (a < c ? a : c);
}

int dist[MAX_SIZE][MAX_SIZE];

void edit_distance(char *a, char *b) {
	for (int i = 0; i < MAX_SIZE; i++) {
		for (int j = 0; j < MAX_SIZE; j++) {
			dist[i][j] = 0;
		}
	}
	
	for (int i = 0; i <= strlen(a); i++) {
		dist[i][0] = i;
	}
	for (int j = 0; j <= strlen(b); j++) {
		dist[0][j] = j;
	}
	for (int i = 1; i <= strlen(a); i++) {
		for (int j = 1; j <= strlen(b); j++) {
			if (a[i-1] == b[j-1]) {
				dist[i][j] = dist[i-1][j-1];
			} else {
				dist[i][j] = min(dist[i-1][j-1] + 1, dist[i-1][j] + 1, dist[i][j-1] + 1);
			}
		}
	}
}

int main(int argc, char *argv[]) {
	edit_distance("abc", "abx");
	printf("%d\n", dist[3][3]);
}
