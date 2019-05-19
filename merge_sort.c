#include <stdio.h>

#define MAX_SIZE 100

int temp[MAX_SIZE];

void copy(int t[], int arr[], int tstart, int tend, int astart) {
	for (int i = 0; i < tend - tstart; i++) {
		arr[astart + i] = t[tstart + i];
	}
}

void merge(int arr[], int start, int end, int start2, int end2) {
	int i = start;
	int j = start2;
	int z = 0;
	while (i <= end && j <= end2) {
		if (arr[i] < arr[j]) {
			temp[z++] = arr[i++];		
		} else {
			temp[z++] = arr[j++];
		}
	}
	while (i <= end) {
		temp[z++] = arr[i++];
	}
	while (j <= end2) {
		temp[z++] = arr[j++];
	}
	copy(temp, arr, 0, z, start);
}

void merge_sort(int arr[], int start, int end) {
	if (start >= end) {
		return;
	}
	int mid = (start + end) / 2;
	merge_sort(arr, start, mid);
	merge_sort(arr, mid + 1, end);
	merge(arr, start, mid, mid + 1, end);	
}

int main(int argc, char *argv[]) {
	int arr[] = {1, 2, 4, -1, 3, 1};
	merge_sort(arr, 0, sizeof(arr)/sizeof(int) - 1);
	for (int i = 0; i < sizeof(arr)/sizeof(int); i++) {
		printf("%d\n", arr[i]);
	}
}
