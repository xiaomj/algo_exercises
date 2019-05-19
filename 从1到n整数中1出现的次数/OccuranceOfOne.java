class OccuranceOfOne {
	int countAfterShiftOne(int n) {
		int count = 0;
		n = n / 10;
		while (n > 0) {
			count++;
			n = n / 10;
		}
		return count;
	}
	
	int pow10(int n, int e) {
		int res = 1;
		while (e > 0) {
			res *= n;
			e--;
		}
		return res;
	}	
	
	int numAfterShiftOne(int n) {
		int count = 0;
		int o = n;
		n = n / 10;
		while (n > 0) {
			count++;
			n = n / 10;
		}
		return o % pow10(10, count);
	}
	
	int firstDigit(int n) {
        while (n / 10 > 0) {
        	n = n / 10;
        }
		return n;
	}	

	public int f(int n) {
		if (n == 0) {
			return 0;
		}
		if (n < 10) {
			return 1;
		}
		int firstDigit = firstDigit(n);
		int countAfterShiftOne = countAfterShiftOne(n);
		int numAfterShiftOne = numAfterShiftOne(n);
	
		//System.out.println(firstDigit);		
		//System.out.println(countAfterShiftOne);
		//System.out.println(numAfterShiftOne);

		if (firstDigit > 1) {
			return pow10(10, countAfterShiftOne) + f(numAfterShiftOne) + f(pow10(10, countAfterShiftOne) - 1) * (firstDigit - 1);
		} else {
			return f(numAfterShiftOne) + f(pow10(10, countAfterShiftOne) - 1) + numAfterShiftOne + 1;
		}
	}

	public static void main(String[] args) {
		System.out.println(new OccuranceOfOne().f(12));
	}
}
