package common;

public class Utils {
	public static void print(int nums[]) {
		if (nums == null) {
			System.out.println("null");
			return;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
			sb.append(',');
		}
		if (sb.length() > 0) {
			sb.setLength(sb.length() - 1);
		}
		System.out.println(sb);
	}
	
	public static void print(Object nums[]) {
		if (nums == null) {
			System.out.println("null");
			return;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
			sb.append(',');
		}
		if (sb.length() > 0) {
			sb.setLength(sb.length() - 1);
		}
		System.out.println(sb);
	}
}
