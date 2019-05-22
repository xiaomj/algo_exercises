import java.lang.Math;

class SumOfSuccessiveNumberV1 {
	public Integer calcRoot(int a, int b, int c) {
		double root = (Math.sqrt(b * b - 4 * a * c) - b) / (2 * a);
		if (root - (int) root < 0.00000001) {
			return (int) root;
		}
		return -1;
	}

	public void find(int sum) {
		int end = sum / 2 + 1;
		int start = calcRoot(1, 1, -2 * sum);
		for (int i = end; i >= start; i--) {
			int t = calcRoot(1, -1, -i * i - i + 2 * sum);
			if (t != -1) {
				System.out.println(t + "->" + i);
			}
		}				
	}

	public static void main(String[] args) {
		new SumOfSuccessiveNumber().find(2000);
	}
}
