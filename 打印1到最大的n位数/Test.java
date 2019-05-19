import java.util.regex.*; 

public class Test {
	static void print(String prefix, int n) {
		if (n == 0) {
			if (!prefix.equals("")) {
				System.out.println(prefix);
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				if (!prefix.equals("")) {
					print(prefix + String.valueOf(i), n - 1);
				} else {
					if (i != 0) {
						print(String.valueOf(i), n - 1);
					} else {
						print("", n - 1);
					}
				}
			}
		}
	}

	static void print2(String prefix, int n) {
		if (n == 0) {
			Matcher m = Pattern.compile("[0]*(.*)").matcher(prefix);
			if (m.find() && !m.group(1).equals("")) {
				System.out.println(m.group(1));
			}
		} else {
			for (int i = 0; i < 10; i++) {
				print2(prefix + String.valueOf(i), n - 1);
			}
		}
	}

	public static void main(String[] args) {
		int n = 3;
		print2("", 3);
	}
}
