#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int find_if_two_sum(int *arr, int i, int j, int target) {
	if (!arr) {
		return 0;
	}
	while (i < j) {
		if (arr[i] + arr[j] < target) {
			i++;
		} else if (arr[i] + arr[j] > target) {
			j--;
		} else {
			return 1;
		}
	}
	return 0;
}

void find_two_sums(int *arr, int i, int j, int target) {
	if (!arr) {
		return;
	}
	while (i < j) {
		if (arr[i] + arr[j] == target) {
			printf("%d, %d\n", arr[i], arr[j]);
			// 处理重复的逻辑
			while (i < j && arr[i] == arr[i + 1]) {
				i++;
			}
			while (i < j && arr[j] == arr[j - 1]) {
				j--;
			}
			// 如果是找到了，继续找
			i++;
		} else if (arr[i] + arr[j] < target) {
			i++;
		} else if (arr[i] + arr[j] > target) {
			j--;
		}
	}
}

int main(int argc, char *argv[]) {
	int arr[] = {1,2,3,3,4,5,5,6,6,6};
	find_two_sums(arr, 0, sizeof(arr)/sizeof(int) - 1, 10);
}
