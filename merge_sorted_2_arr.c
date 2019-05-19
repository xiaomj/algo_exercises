#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void merge_sorted_arr(int arr[], int size_arr, int brr[],int size_brr) {
	int i = size_arr - 1;
	int j = size_brr - 1;
	int z = size_arr + size_brr - 1;

	while (i >= 0 && j >= 0) {
		if (arr[i] < brr[j]) {
			arr[z--] = brr[j--];
		} else {
			arr[z--] = arr[i--];
		}
	}
	while (i >= 0) {
		arr[z--] = arr[i--];
	}
	while (j >= 0) {
		arr[z--] = brr[j--];
	}
}

int main(int argc, char **argv) {
	int arr[100] = {1, 2, 3, 4, 5};
	int brr[] = {2, 3, 4, 5};
	merge_sorted_arr(arr, 5, brr, 4);
	for (int i = 0; i < 9; i++) {
		printf("%d\n", arr[i]);
	}
}
