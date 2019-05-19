class JoinToMin {
	void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	Integer compare(int a, int b) {
		String str1 = String.valueOf(a) + String.valueOf(b);
		String str2 = String.valueOf(b) + String.valueOf(a);
		return str1.compareTo(str2);
	}	
	
	Integer partition(int[] arr, int startPos, int endPos) {
		if (startPos >= endPos) {
			return startPos;
		}
		int midVal = arr[startPos];
		int i = startPos;
		int j = endPos;
		while (i < j) {
			while (j > i && compare(arr[j], midVal) >= 0) {
				j--;
			}
			while (i < j && compare(arr[i], midVal) <= 0) {
				i++;
			}
			swap(arr, i, j);
		}
		swap(arr, i, startPos);
		return i;
	}
	
	void internalSort(int[] arr, int i, int j) {
		if (i >= j) {
			return;
		}
		int splitPos = partition(arr, i, j);
		internalSort(arr, i, splitPos - 1);
		internalSort(arr, splitPos + 1, j);
	}

	public void sort(int[] arr) {
		internalSort(arr, 0, arr.length - 1);			
	}

	public static void main(String[] args) {
		int[] arr = {3, 32, 321};
		new JoinToMin().sort(arr);
		for (int i: arr) {
			System.out.println(i);
		}
	}
}
