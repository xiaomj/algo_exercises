void swap(int arr[], int i, int j) {
	int s = arr[i];
	arr[i] = arr[j];
	arr[j] = s;
}

void quick_sort(int arr[], int start, int end) {
	if (start >= end) {
		return;
	}
	int sentry = arr[start];
	int i = start;
	int j = end;
	while (i < j) {
		if (arr[i] > sentry) {
			swap(arr, i, j);
			j--;
		} else {
			i++;
		}
	}
	arr[start] = arr[i];
	arr[i] = sentry;
	quick_sort(arr, start, i-1);
	quick_sort(arr, i+1, end);
}

void main(int argc, char* args[]) {
	int arr[] = {1, 2, -1, 3, 1};
	quick_sort(arr, 0, 4);
	for (int i = 0; i < 5; i++) {
		printf("%d\n", arr[i]);
	}
}
