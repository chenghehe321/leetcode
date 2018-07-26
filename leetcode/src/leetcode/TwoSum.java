package leetcode;

import common.Utils;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TwoSum t = new TwoSum();
		int[] nums = { -1, -2, -3, -4, -5 };
		int target = -8;
		Utils.print(t.twoSum(nums, target));
	}
}
