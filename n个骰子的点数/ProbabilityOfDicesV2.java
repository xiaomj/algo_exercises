import java.util.*;

class ProbabilityOfDicesV2 {
	int[] internalCalc(int n) {
		int[] map = new int[7];
		for (int i = 1; i <= 6; i++) {
			map[i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			int[] res = new int[i * 6 + 1];
			for (int j = i - 1; j <= (i - 1) * 6; j++) {
				for (int k = 1; k <= 6; k++) {
					res[j + k] += map[j];
				}
			}
			map = res;
		}
		return map;			
	}

	void calc(int n) {
		int[] map = internalCalc(n);
		int sum = 0;
		for (int i = n; i <= n * 6; i++) {
			sum += map[i];
		}
		System.out.println(sum);
		for (int i = n; i <= n * 6; i++) {
			System.out.println(map[i] / (double) sum);
		}
	}

	public static void main(String[] args) {
		new ProbabilityOfDicesV2().calc(6);
	}
}
