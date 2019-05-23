import java.util.*;

class ProbabilityOfDicesV1 {
	
	Map<Integer, Integer> countOfSum = new HashMap<>();
	Map<Integer, Integer> countOfSum2 = new HashMap<>();
	Integer sumAll = 0;

	public void internalCalc(int sum, int n) {
		if (n == 0) {
			if (countOfSum.containsKey(sum)) {
				countOfSum.put(sum,	countOfSum.get(sum) + 1);
			} else {
				countOfSum.put(sum, 1);
			}
			sumAll++;
		} else {
			for (int i = 1; i <= 6; i++) {
				internalCalc(sum + i, n - 1);
			}
		}
	}

	public void calc(int n) {
		internalCalc(0, n);
		System.out.println(sumAll);
		for (Integer key: countOfSum.keySet()) {
			Integer count = countOfSum.get(key);		
			System.out.println(count / (double) sumAll);
		}
	}

	public static void main(String[] args) {
		new ProbabilityOfDicesV1().calc(6);
	}
}
