class DeleteAllOfOtherSentence {
	public String delete(String src, String arg) {
		if (src == null || arg == null) {
			return src;
		}
		int[] index = new int[256];
		for (int i = 0; i < arg.length(); i++) {
			index[(int) arg.charAt(i)] = 1;
		}
		String ret = "";
		for (int i = 0; i < src.length(); i++) {
			if (index[(int) src.charAt(i)] == 0) {
				ret += src.charAt(i);
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(new DeleteAllOfOtherSentence().delete("We are students.", "aeiou"));
	}
}
