class MoreThanHalfV2 {
	
	void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}	

	public void partition(int[] arr, int n, int startPos, int endPos) {
		if (startPos >= endPos) {
			return;
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
			partition(arr, n, startPos, i - 1);
		} else if (n > i) {
			partition(arr, n, i + 1, endPos);
		} else {
			return;
		}
	}

	public Integer findIt(int[] arr) {
		if (arr == null) {
			return -1;
		}
		if (arr.length == 1) {
			return arr[0];
		}
		partition(arr, (arr.length + 1) / 2 - 1, 0, arr.length - 1);
		return arr[(arr.length + 1) / 2 - 1];
	}

	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 0, 2, 0, 2, 2, 0, 2, 2};
		System.out.println(new MoreThanHalf().findIt(arr));
	}
}
