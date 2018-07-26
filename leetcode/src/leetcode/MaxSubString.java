package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxSubString {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int start = 0, end = 1, max = 1, curr = 1;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put(s.charAt(start), 0);
		while (end < s.length()) {
			char endChar = s.charAt(end);
			if (map.containsKey(endChar)) {
				int index = map.get(endChar);
				for (int i = start; i <= index; i++) {
					map.remove(s.charAt(i));
				}
				start = index + 1;
				map.put(endChar, end);
				end++;
				curr = end - start;
			} else {
				map.put(s.charAt(end), end);
				curr++;
				end++;
			}
			max = curr > max ? curr : max;
		}
		System.out.println("start=[" + start + "], end=[" + end + "]");
		return max;
	}

	public static void main(String[] args) {
		String s = " ";
		MaxSubString o = new MaxSubString();
		System.out.println(o.lengthOfLongestSubstring(s));
	}
}
