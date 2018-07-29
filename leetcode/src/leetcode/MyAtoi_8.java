package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MyAtoi_8 {

	public static int myAtoi(String str) {
		if (str == null || (str = str.trim()).length() == 0) {
			return 0;
		}
		boolean isNegative = false;
		int index = 0;
		long num = 0l;
		char c = str.charAt(index);
		if (c == '-' || c == '+') {
			if (c == '-') {
				isNegative = true;
			}
			if (++index < str.length()) {
				c = str.charAt(index);
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		while (c >= 48 && c <= 57 && index < str.length()) {
			list.add(Integer.valueOf(c + ""));
			if (++index >= str.length()) {
				break;
			}
			c = str.charAt(index);
		}
		int curr = list.size();
		for (int i = 0; i < list.size(); i++) {
			num += (Math.pow(10, --curr) * list.get(i) * (isNegative ? -1 : 1));
			if (num >= Integer.MAX_VALUE) {
				num = Integer.MAX_VALUE;
				break;
			}
			if (num <= Integer.MIN_VALUE) {
				num = Integer.MIN_VALUE;
				break;
			}
		}
		return (int) num;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("-2147483647"));
	}

}
