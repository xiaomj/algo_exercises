import java.util.regex.*;

class Atoi {
	Integer convert(String src) throws Exception {
		if (src == null || "".equals(src)) {
			throw new Exception("wrong format");
		}

		// 最小负整数检测
		if (String.valueOf(Integer.MIN_VALUE).equals(src)) {
			return Integer.MIN_VALUE;
		}
		
		Boolean ltZero = false;
		// 符号检测
		if (src.charAt(0) == '-') {
			ltZero = true;
			src = src.substring(1);
		} else if (src.charAt(0) == '+') {
			src = src.substring(1);
		}

		//  是否包含异常字符
		Matcher m = Pattern.compile("[0-9]{1,11}").matcher(src);
		if (!m.matches()) {
			throw new Exception("wrong format");
		}
		
		// 转换	
		Integer result = 0;
		for (int i = 0; i < src.length(); i++) {
			result = result * 10 + (src.charAt(i) - '0');
			if (result < 0) {
				throw new Exception("overflow");
			}
		}
		return ltZero ? -result : result;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new Atoi().convert("-2147483649"));
	}
}
