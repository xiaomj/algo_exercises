import java.util.*;

class FindMinK {
	public void minK(int[] arr, int k) {
		TreeSet<Integer> heap = new TreeSet<>();
		int i = 0;
		while (i < arr.length) {
			if (heap.size() < k) {
				heap.add(arr[i]);
			} else {
				if (heap.last() > arr[i]) {
					heap.remove(heap.last());
					heap.add(arr[i]);
				}
			}
			i++;
		}
		for (int j: heap) {
			System.out.println(j);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 1};
		new FindMinK().minK(arr, 3);
	}
}
