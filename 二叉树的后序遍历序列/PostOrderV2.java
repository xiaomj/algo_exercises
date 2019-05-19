class PostOrderV2 {
	public Boolean check(int[] arr, int startPos, int endPos) {
		if (arr == null || startPos >= endPos) {
			return true;
		}
		int root = arr[endPos];
		int i = startPos;
		while (i < endPos && arr[i] <= root) {
			i++;
		}
		int splitPos = i;	
		while (i < endPos && arr[i] > root) {
			i++;
		}
		if (i < endPos) { 
			return false;
		}
		return check(arr, startPos, splitPos - 1) && check(arr, splitPos, endPos - 1);
	}

	public static void main(String[] args) {
		int[] arr = {3,4,6,5};
		System.out.println(new PostOrderV2().check(arr, 0, arr.length - 1));
	}
}
