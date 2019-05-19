#include <stdlib.h>
#include <stdio.h>

void swap(int arr[], int i, int j) {
	int s = arr[i];
	arr[i] = arr[j];
	arr[j] = s;
}

void partition(int arr[], int start, int end) {
	if (start >= end) {
		return;
	}
	int sentry = arr[start];
	int i = start;
	int j = end;
	
	while (i < j) {
			while (arr[j] >= sentry && i < j) {
				j--;
			}
			while (arr[i] <= sentry && i < j) {
				i++;
			}
			swap(arr, i, j);
	}
	
	swap(arr, i, start);
	
	partition(arr, start, i-1);
	partition(arr, i+1, end);
}

void main(int argc, char* args[]) {
	int arr[] = {1, 2, -1, 3, 1};
	partition(arr, 0, 4);
	for (int i = 0; i < 5; i++) {
		printf("%d\n", arr[i]);
	}
}
