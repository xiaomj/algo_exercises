class StringPermutation {
	
	Boolean exist(char[] src, int start, int end, char target) {
		for (int j = start; j <= end; j++) {
			if (src[j] == target) {
				return true;
			}
		}
		return false;
	}

	void internalPermutation(String res, char[] src, int pos) {
		if (pos == src.length) {
			System.out.println(res.toString());
			return;
		}
		internalPermutation(res + src[pos], src, pos + 1);
		for (int i = pos + 1; i < src.length; i++) {
			if (src[i] != src[pos] && !exist(src, pos, i - 1, src[i])) {
				char t = src[pos];
				src[pos] = src[i];
				src[i] = t;
				internalPermutation(res + src[pos], src, pos + 1);
				t = src[i];
				src[i] = src[pos];
				src[pos] = t;
			}
		}
	}
	
	void printPermutation(char[] src) {
		internalPermutation("", src, 0);
	}

	public static void main(String[] args) {
		new StringPermutation().printPermutation("34356".toCharArray());
	}
}
