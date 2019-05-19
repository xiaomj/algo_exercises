public class Test {
	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];	
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void reorder(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			while (i < j && arr[i] % 2 == 1) {
				i++;
			}
			while (i < j && arr[j] % 2 == 0) {
				j--;
			}
			if (i < j) {
				swap(arr, i, j);
			}
		}
	}

	public static void main(String[] args) {
		//int[] arr = new int[]{1,2,3,3,4};
		int[] arr = new int[]{1};
		reorder(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);	
		}
	}
}
