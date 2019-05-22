class FirstOccureOne {
	public void find(char[] src) {
		int[] index = new int[1000];

		for (int i = 0; i < index.length; i++) {
			index[i] = 0;
		}

		for (int i = 0; i < src.length; i++) {
			char ch = src[i];
			index[(int) ch]++;
		}

		for (int i = 0; i < src.length; i++) {
			char ch = src[i];
			if (index[(int) ch]	== 1) {
				System.out.println(ch);
				break;
			}
		}
	}

	public static void main(String[] args) {
		new FirstOccureOne().find("abdddcefacef".toCharArray());
	}
}
