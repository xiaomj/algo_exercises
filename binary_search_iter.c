#include <stdio.h>
#include <stdlib.h>


int binary_search(int arr[], int i, int j, int target) {
	int start = i;
	int end = j;
	while (start < end) {
		int mid = (start + end) / 2;
		if (arr[mid] == target) {
			return 1;
		} else if (arr[mid] < target) {
			start = mid + 1;
		} else {
			end = mid - 1;
		}
	}
	return 0;
}


int main(int argc, char *argv[]) {
	int arr[] = {1, 2, 3, 4, 4, 5, 5, 10, 11};
	printf("%d\n", binary_search(arr, 0, sizeof(arr)/sizeof(int), 2));
}
