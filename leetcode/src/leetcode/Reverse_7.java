package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Reverse_7 {
	public static int reverse(int x) {
		boolean isNegative = false;
		if (x < 0)
			isNegative = true;
		x = Math.abs(x);
		int curr = x;
		long y = 0l;
		List<Integer> list = new ArrayList<Integer>();
		while (curr > 0) {
			list.add(curr % 10);
			curr /= 10;
		}
		int size = list.size();
		for (int i = 0; i < list.size(); i++) {
			y += (Math.pow(10, --size) * list.get(i));
			if (y > Integer.MAX_VALUE) {
				return 0;
			}
		}
		return (int) (isNegative ? y * -1 : y);
	}

	public static void main(String[] args) {
		int a = Integer.MAX_VALUE + 1;
		System.out.println(reverse((Integer.MAX_VALUE - 1) * -1));
	}
}
