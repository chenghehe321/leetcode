package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x < 10) {
			return true;
		}
		int size = 0, count = 0;
		long curr = Long.valueOf(x);
		long result = 0l;
		List<Long> list = new ArrayList<Long>();
		while (x > 0) {
			list.add(Long.valueOf(x % 10));
			size++;
			x = x / 10;
		}
		while (size > 0) {
			result += (list.get(count++) * Math.pow(10, --size));
		}
		return curr == result;
	}
}
