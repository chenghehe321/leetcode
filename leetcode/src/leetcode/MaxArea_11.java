package leetcode;

public class MaxArea_11 {

	public static int maxArea(int[] height) {
		int start = 0, end = height.length - 1, maxArea = 0;
		while (start < end) {
			int curr = (end - start) * Math.min(height[start], height[end]);
			if (curr > maxArea) {
				maxArea = curr;
			}
			if (height[start] <= height[end]) {
				start++;
			} else {
				end--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {

	}
}
