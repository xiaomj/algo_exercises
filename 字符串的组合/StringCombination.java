class StringCombination {
	public void internalCombinate(String res, char[] src, int pos) {
		if (pos == src.length) {
			if (!"".equals(res)) {
				System.out.println(res);
			}
			return;
		}

		int countOfCur = 1;
		int j = pos;
		while (j + 1 < src.length && src[j] == src[j + 1]) {
			countOfCur++;
			j++;	
		}

		internalCombinate(res, src, pos + countOfCur);
		for (int i = 1; i <= countOfCur; i++) {
			res += src[pos];
			internalCombinate(res, src, pos + countOfCur);
		}
	}

	public void stringCombination(char[] src) {
		internalCombinate("", src, 0);	
	}

	public static void main(String[] args) {
		new StringCombination().stringCombination("1112234".toCharArray());
	}
}
