import java.util.*;

class OrderOfPoker {
	private static Map<Character, Integer> dict = new HashMap<>();
	static {
		for (int i = 2; i <= 10; i++) {
			dict.put((char)(i + '0'), i);
		}
		dict.put('A', 1);
		dict.put('J', 11);	
		dict.put('Q', 12);
		dict.put('K', 13);
	}

	public Boolean check(char[] arr) {
		List<Integer> intArr = new ArrayList<>();
		Boolean hasSmallKing = false;
		Boolean hasBigKing = false;
		for (int i = 0; i < arr.length; i++) {
			if (dict.containsKey(arr[i])) {
				intArr.add(dict.get(arr[i]));
			} else if (!hasSmallKing) {
				hasSmallKing = true;
			} else {
				hasBigKing = true;
			}
		}

		Collections.sort(intArr);

		int preVal = intArr.get(0);	
		int curVal = -1;
		int i = 1;
		while (i < intArr.size()) {
			curVal = intArr.get(i);
			if (curVal - preVal != 1) {
				if (hasSmallKing) {
					hasSmallKing = false;
				} else if (hasBigKing) {
					hasBigKing = false;
				} else {
					return false;
				}
				curVal = preVal + 1;
			} else {
				i++;
			}
			preVal = curVal;
		}
		return true;	
	}

	public static void main(String[] args) {
		char[] arr = {'A', '2', '3', '9', 'F'};
		System.out.println(new OrderOfPoker().check(arr));
	}
}
