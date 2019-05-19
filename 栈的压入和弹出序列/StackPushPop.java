import java.util.*;

class StackPushPop {
	private Stack<Integer> stack = new Stack<Integer>();

	public Boolean check(int[] arr, int[] brr) {
		if (arr == null || brr == null || arr.length != brr.length) {
			return false;
		}
		int i = 0;
		int j = 0;
		while (i <= arr.length && j <= brr.length) {
			if (j < brr.length && stack.size() != 0 && stack.peek() == brr[j]) {
				stack.pop();
				j++;
			} else if (i < arr.length) {
				stack.push(arr[i]);
				i++;
			} else {
				break;
			}
		}
		if (stack.size() != 0 || i != arr.length || j != brr.length) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] brr = {4,3,5,1,2};
		System.out.println(new StackPushPop().check(arr, brr));
	}
}
