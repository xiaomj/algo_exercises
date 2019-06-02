class CheckPassword {
	public Boolean check(String src) {
		Integer capitalCount;
		Integer smallCount;
		Integer numCount;
		Integer signCount;
		
		for (int i = 0; i < src.length; i++) {
			if (src.charAt(i) <= 'z' && src.charAt(i) >= 'a') {
				smallCount++;
			} else if (src.charAt(i) <= 'Z' && src.charAt(i) >= 'A') {
				bigCount++;
			} else if (src.charAt(i) <= '9' && src.charAt(i) >= '0') {
				numCount++;
			} else if (src.charAt(i) >= 0 && src.charAt(i) <= 255) {
				signCount++;
			}
		}
		if (
}
