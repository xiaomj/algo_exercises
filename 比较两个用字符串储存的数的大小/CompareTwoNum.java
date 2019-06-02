import java.util.regex.*;

class FloatNum {
	Boolean ltZero = false;
	String integerPart;
	String floatPart;
	
	public void parse(String a) {
		Pattern p = Pattern.compile("([-+])?([0-9]+)(\\.[0-9]+)?");		
		Matcher ma = p.matcher(a);

		ma.find();
		if (ma.group(1) != null && "-".equals(ma.group(1))) {
			ltZero = true;
		}

		integerPart = ma.group(2);

		floatPart = ma.group(3);
		if (floatPart == null) {
			floatPart = "0";
		}
		integerPart = removeHeadingZeros(integerPart);		
		floatPart = removeAppendingZeros(floatPart);	
	
		// 考虑0
		if (integerPart.equals("0") && floatPart.equals(".0")) {
			ltZero = false;
		}
	}

	public FloatNum(String src) {
		parse(src);
	}
	
	Integer compare(String ia, String fa, String ib, String fb) {
		if (ia.length() == ib.length()) {
			if (ia.compareTo(ib) == 0) {
				return fa.compareTo(fb);
			} else {
				return ia.compareTo(ib);
			}
		} else if (ia.length() > ib.length()) {
			return 1;
		} else {
			return -1;
		}
	}

	String removeHeadingZeros(String a) {
		String res = "";
		int i = 0;
		while (i < a.length() - 1) {
			if (a.charAt(i) == '0') {
				i++;
			} else {
				break;
			}
		}	
		return a.substring(i);
	}

	String removeAppendingZeros(String b) {
		int i = b.length() - 1;
		while (i > 1) {
			if (b.charAt(i) == '0') {
				i--;
			} else {
				break;
			}
		}
		return b.substring(0, i + 1);
	}


	public Integer compare(FloatNum b) {
		if (ltZero && b.ltZero) {
			return compare(integerPart, floatPart, b.integerPart, b.floatPart);
		} else if (!ltZero && !b.ltZero) {
			return -compare(integerPart, floatPart, b.integerPart, b.floatPart);
		} else if (!ltZero && b.ltZero) {
			return 1;
		} else {
			return -1;
		}	
	}
}

class CompareTwoNum {
	public static void main(String[] args) {
		FloatNum fn = new FloatNum("+0.00");
		FloatNum fn2 = new FloatNum("-0.00");
		System.out.println(fn.compare(fn2));
	}
}
