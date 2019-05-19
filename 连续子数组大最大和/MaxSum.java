class MaxSum {
	public void calc(int[] arr) {
		int[] maxSum = new int[arr.length];
		int[] maxIndex = new int[arr.length];
		
		maxSum[0] = arr[0];
		maxIndex[0] = 0;
		
		int max = -1;
		int startPos = 0;
		int endPos = 0;

		for (int i = 1; i < arr.length; i++) {
			if (maxSum[i - 1] > 0) {
				maxSum[i] = maxSum[i - 1] + arr[i];
				maxIndex[i] = maxIndex[i - 1];
			} else {
				maxSum[i] = arr[i];
				maxIndex[i] = i;
			}
			if (maxSum[i] > max) {
					startPos = maxIndex[i];
					endPos = i;
					max = maxSum[i];
			}
		}
		System.out.println(max);
		System.out.println(startPos);	
		System.out.println(endPos);	
	}

	public static void main(String[] args) {
		int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
		new MaxSum().calc(arr);
	}
}
