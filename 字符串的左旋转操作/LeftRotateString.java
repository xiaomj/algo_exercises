class LeftRotateString {
	
	void internalReverse(char[] str, int startPos, int endPos) {
		if (str == null) {
			return;
		}
		if (startPos < 0 || endPos < 0) {
			return;
		}
		int i = startPos;
		int j = endPos;
		while (i < j) {
			swap(str, i, j);
			i++;
			j--;
		}
	}
	
	void swap(char[] str, int i, int j) {
		char t = str[i];
		str[i] = str[j];
		str[j] = t;
	}

	public void rotate(char[] str, int moveStep) {
		internalReverse(str, 0, str.length - 1);
		internalReverse(str, 0, str.length - 1 - moveStep);	
		internalReverse(str, str.length - moveStep, str.length - 1);
	}
	
	public static void main(String[] args) {
		char[] str = {'a', 'b', 'c', 'd', 'e', 'f'};
		new LeftRotateString().rotate(str, 6);
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
		System.out.println();
	}
}
