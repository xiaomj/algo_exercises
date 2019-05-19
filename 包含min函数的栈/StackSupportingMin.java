import java.util.*;

class StackSupportingMin<T extends Comparable<T>> {
	Stack<T> dataStack = new Stack<>();
	Stack<T> minStack = new Stack<>();
	
	public void push(T a) {
		dataStack.push(a);
		if (minStack.empty()) {
			minStack.push(a);
		} else if (minStack.peek().compareTo(a) > 0) {
			minStack.push(a);
		} else {
			minStack.push(minStack.peek());
		}
	}
	
	public void pop() {
		dataStack.pop();
		minStack.pop();
	}

	public T min() {
		T top = minStack.peek();
		minStack.pop();
		return top;				
	}

	public static void main(String[] args) {
		StackSupportingMin<Integer> ssm = new StackSupportingMin();
		ssm.push(1);
		ssm.push(4);
		ssm.push(2);
		System.out.println(ssm.min());
	}
}
