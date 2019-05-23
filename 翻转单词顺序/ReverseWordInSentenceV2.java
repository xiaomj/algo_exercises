class ReverseWordInSentenceV2 {
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
		
		int i = 0;
		while (i < src.length) {
			// 要考虑到全部空
			while (i < src.length && src[i] == ' ') {
				i++;
			}
			startPos = i;
			// 要考虑到全部非空
			while (i < src.length && src[i] != ' ') {
				i++;
			}
			endPos = i - 1;
			reverseInternal(src, startPos, endPos);
		}
	}
	
	public static void main(String[] args) {
		char[] str = {'a', 'b', ' ', 'c', 'd', 'e'};
		new ReverseWordInSentence().reverse(str);
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
}
