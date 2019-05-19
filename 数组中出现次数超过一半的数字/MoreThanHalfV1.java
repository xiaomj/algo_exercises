class MoreThanHalfV1 {
	
	void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}	

	public Integer partition(int[] arr, int n, int startPos, int endPos) {
		if (startPos >= endPos) {
			if (n != 0) {
				return -1;
			}
			return arr[startPos];
		}

		int midVal = arr[startPos];
		int i = startPos;
		int j = endPos;

		while (i < j) {
			while (i < j && arr[j] >= midVal) {
				j--;
			}
			while (i < j && arr[i] <= midVal) {
				i++;
			}
			swap(arr, i, j);
		}
		swap(arr, startPos, i);
		if (n < i) {
			return partition(arr, n, startPos, i - 1);
		} else if (n > i) {
			return partition(arr, n - i - 1, i + 1, endPos);
		} else {
			return midVal;
		}
	}

	public Integer findIt(int[] arr) {
		if (arr == null) {
			return -1;
		}
		if (arr.length == 1) {
			return arr[0];
		}
		return partition(arr, (arr.length + 1) / 2 - 1, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] arr = {1, 1};
		System.out.println(new MoreThanHalf().findIt(arr));
	}
}
