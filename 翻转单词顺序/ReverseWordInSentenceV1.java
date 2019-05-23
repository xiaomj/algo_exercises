class ReverseWordInSentence {
	void swap(char[] src, int i, int j) {
		char t = src[i];
		src[i] = src[j];
		src[j] = t;
	}
	
	void reverseInternal(char[] src, int i, int j) {
		if (i >= j) {
			return;
		}
		int startPos = i;
		int endPos = j;
		while (i < j) {
			swap(src, i, j);
			i++;
			j--;
		}
	}
	
	public void reverse(char[] src) {
		if (src == null) {
			return;
		}
		reverseInternal(src, 0, src.length - 1);

		int startPos = 0;
		int endPos = 0;
		for (int i = 0; i < src.length; i++) {
			if (src[i] == ' ') {
				endPos = i - 1;
				reverseInternal(src, startPos, endPos);
				while (i < src.length && src[i] == ' ') {
					i++;
				}
				if (i < src.length) {
					startPos = i;
				}
			}
		}
		if (src[src.length - 1] != ' ') {
			reverseInternal(src, startPos, src.length - 1);
		}
	}
	
	public static void main(String[] args) {
		char[] str = {'a', 'b', ' ', ' ', ' '};
		new ReverseWordInSentence().reverse(str);
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
}
