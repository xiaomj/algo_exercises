class LastNumberLeftInCircle {
	
	Integer find(int m, int n) {
		if (m == 1) {
			return 0;
		}
		return (find(m - 1, n) + n) % ( m );
	}

	public static void main(String[] args) {
		System.out.println(new LastNumberLeftInCircle().find(5, 3));	
	}
}
