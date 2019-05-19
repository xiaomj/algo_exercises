class MoreThanHalfV4 {
	public Integer findMoreHalf(int[] arr) {
		int i = 0;
		int count = 0;
		int target = -1;
		
		while (i < arr.length) {
			if (count == 0) {
				count++;
				target = arr[i];
			} else {
				if (arr[i] != target) {
					count--;
				} else {
					count++;
				}
			}
			i++;
		}
		i = 0;
		int sum = 0;
		while (i < arr.length) {
			if (arr[i] == target) {
				sum++;
			}
			i++;
		}
		if (sum < arr.length / 2 + 1) {
			return -1;
		}
		return target;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 0}; 
		System.out.println(new MoreThanHalfV4().findMoreHalf(arr));
	}
}
