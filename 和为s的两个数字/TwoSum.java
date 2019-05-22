class TwoSum {
	public void find(int[] arr, int sum) {
		if (arr == null) {
			return;
		}
		int startPos = 0;
		int endPos = arr.length - 1;
		while (startPos < endPos) {
			if (arr[startPos] + arr[endPos] == sum) {
				System.out.println(arr[startPos]);
				System.out.println(arr[endPos]);
				break;
			} else if (arr[startPos] + arr[endPos] > sum) {
				endPos--;
			} else {
				startPos++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 7, 8};
		new TwoSum().find(arr, 9);
	}	
}
