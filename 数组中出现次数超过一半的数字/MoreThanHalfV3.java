class MoreThanHalfV3 {
	
	void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}	
	
	Integer partition(int[] arr, int startPos, int endPos) {
		if (startPos >= endPos) {
			return startPos;
		}

		int midVal = arr[startPos];
		int i = startPos;
		int j = endPos;
		while (i < j) {
			while (j > i && arr[j] >= midVal) {
				j--;
			}
			while (i < j && arr[i] <= midVal) {
				i++;
			}
			swap(arr, i, j);
		}
		swap(arr, i, startPos);
		return i;
	}
	
	public Integer findHalf(int[] arr) {
		int targetIndex = arr.length / 2;
		int startPos = 0;
		int endPos = arr.length - 1;
		
		while (true) {
			int index = partition(arr, startPos, endPos);
			if (index < targetIndex) {
				startPos = index + 1;
			} else if (index > targetIndex) {
				endPos = index - 1;
			} else {
				break;
			}
		}
		int i = targetIndex;
		while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
			i++;
		}
		if (i != arr.length - 1) {
			return -1;
		}
		return arr[targetIndex];
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 0, 0, 1, 1};
		System.out.println(new MoreThanHalfV3().findHalf(arr));
	}
}
