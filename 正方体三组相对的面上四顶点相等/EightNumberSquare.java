import java.util.*;

class EightNumberSquare {
	Boolean checkValid(List<Integer> res) {
		if (res.get(0) + res.get(1) + res.get(2) + res.get(3) == res.get(4) + res.get(5) + res.get(6) + res.get(7) && 
			res.get(0) + res.get(2) + res.get(4) + res.get(6) == res.get(1) + res.get(3) + res.get(5) + res.get(7) && 
			res.get(0) + res.get(1) + res.get(4) + res.get(5) == res.get(2) + res.get(3) + res.get(6) + res.get(7)) {
			return true;
		}
		return false;
	}

	void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}	

	void internalFind(List<Integer> res, int[] arr, int pos) {
		if (pos == arr.length) {
			if (checkValid(res)) {
				for (int i = 0; i < res.size(); i++) {
					System.out.print(res.get(i) + " ");
				}
				System.out.println();
			}	
			return;	
		}
		for (int i = pos; i < arr.length; i++) {
			// 处理重复的
			if (i > pos && arr[pos] == arr[i]) {
				continue;
			}
			// 处理重复的
			if (i > pos) {
				Boolean skip = false;
				for (int j = pos + 1; j < i; j++) {
					if (arr[j] == arr[i]) {
						skip = true;
					}
				}
				if (skip) {
					continue;
				}
			}
			swap(arr, i, pos);
			res.add(arr[pos]);
			internalFind(res, arr, pos + 1);
			res.remove(res.size() - 1);
			swap(arr, i, pos);
		} 
	}

	public void findPermutations(int[] arr) {
		internalFind(new ArrayList<>(), arr, 0);	
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 3, 5, 6, 7, 8};
		new EightNumberSquare().findPermutations(arr);
	}
}
