class SumOfSuccessiveNumberV2 {
	public void find(int sum) {
		int start = 1;
		int end = 2;
		int max = sum / 2 + 1;
		
		int curSum = start + end;
		while (start < end && end <= max) {
			if (curSum < sum) {
				end++;
				curSum += end;
			} else if (curSum > sum) {
				curSum -= start;
				start++;
			} else {
				System.out.println(start + "->" + end);
				end++;
				curSum += end;
			}
		}
	}
	
	public static void main(String[] args) {
		new SumOfSuccessiveNumberV2().find(2000);
	}
}
