class OccuranceInOrderedArray {

	Integer leftInternalSum(int[] arr, int startPos, int endPos, int target) {
		if (startPos >= endPos) {
			return startPos;
		}

		int midPos = (startPos + endPos) / 2;
		int midVal = arr[midPos];
		if (midVal < target) {
			if (arr[midPos + 1] == target) {
				return midPos + 1;
			} else {		
				return leftInternalSum(arr, midPos + 1, endPos, target);
			}
		} else {
			if (arr[midPos - 1] != target) {
				return midPos;
			} else {
				return leftInternalSum(arr, startPos, midPos - 1, target);
			}
		}
	}

	Integer rightInternalSum(int[] arr, int startPos, int endPos, int target) {
		if (startPos >= endPos) {
			return startPos;
		}

		int midPos = (startPos + endPos) / 2;
		int midVal = arr[midPos];
		if (midVal > target) {
			if (arr[midPos - 1] == target) {
				return midPos - 1;
			} else {		
				return leftInternalSum(arr, startPos, midPos - 1, target);
			}
		} else {
			if (arr[midPos + 1] != target) {
				return midPos;
			} else {
				return leftInternalSum(arr, midPos + 1, endPos, target);
			}
		}
	}

	void internalSum(int[] arr, int startPos, int endPos, int target) {
		if (startPos >= endPos) {
			if (arr[startPos] == target) {
				System.out.println(startPos);
				System.out.println(endPos);
			}
			return;
		}

		int midPos = (startPos + endPos) / 2;
		int midVal = arr[midPos];

		if (midVal < target) {
			internalSum(arr, midPos + 1, endPos, target);
		} else if (midVal > target) {
			internalSum(arr, startPos, midPos - 1, target);
		} else {
			if (arr[midPos - 1] != target) {
				System.out.println(midPos);
			} else {
				System.out.println(leftInternalSum(arr, startPos, midPos - 1, target));
			}
			if (arr[midPos + 1] != target) {		
				System.out.println(midPos);
			} else {
				System.out.println(rightInternalSum(arr, midPos + 1, endPos, target));
			}
		}
	}

	public void sum(int[] arr, int target) {
		internalSum(arr, 0, arr.length - 1, target);		
	}

	public static void main(String[] args) {
		int[] arr = {3, 3, 3, 3, 3, 3, 3, 3, 3};
		new OccuranceInOrderedArray().sum(arr, 3);
	}
}
