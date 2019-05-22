class DeleteDuplicateChar {
	public void delete(char[] src) {
		int i = 0;
		int[] index = new int[256];

		for (i = 0; i < index.length; i++) {
			index[i] = 0;
		}
		
		int p = 0;
		i = 0;
		while (i < src.length) {
			int charInt = (int) src[i];
			if (index[charInt] != 1) {
				src[p++] = src[i++];
			} else {
				i++;
			}
			index[charInt] = 1;						
		}
		i = 0;
		while (i < p) {
			System.out.println(src[i]);
			i++;
		}
	}

	public static void main(String[] args) {
		new DeleteDuplicateChar().delete("google".toCharArray());
	}
}
