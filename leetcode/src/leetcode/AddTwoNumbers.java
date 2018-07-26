package leetcode;

import java.util.ArrayList;
import java.util.List;

class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {

	public int transToInt(ListNode link) {
		List<Integer> list = new ArrayList<Integer>();
		while (link != null) {
			list.add(link.val);
			link = link.next;
		}
		int size = list.size();
		int count = 1, sum = 0;
		for (int i = 0; i < size; i++) {
			sum += (list.get(i) * count);
			count *= 10;
		}
		return sum;
	}

	public ListNode transToLink(int num) {
		if (num == 0) {
			return new ListNode(0);
		}
		ListNode root = new ListNode(num % 10);
		num /= 10;
		if (num == 0) {
			return root;
		}
		ListNode curr = root;
		while (num > 0) {
			ListNode node = new ListNode(num % 10);
			curr.next = node;
			num /= 10;
			curr = node;
			if (num == 0) {
				break;
			}
		}
		return root;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode root = new ListNode(0);
		ListNode curr = root;
		boolean flag = (l1.val + l2.val) > 9 ? true : false;
		boolean init = true;
		while (l1 != null & l2 != null) {
			int sum = l1.val + l2.val;
			if (flag) {
				sum = init ? sum : sum + 1;
				init = false;
				flag = false;
			}
			if (sum > 9) {
				flag = true;
				sum %= 10;
			}
			ListNode node = new ListNode(sum);
			l1 = l1.next;
			l2 = l2.next;
			curr.next = node;
			curr = curr.next;
			init = false;
		}
		if (l1 == null && l2 != null) {
			curr.next = l2;
		}
		if (l2 == null && l1 != null) {
			curr.next = l1;
		}

		while (flag) {
			if (curr.next == null) {
				ListNode node = new ListNode(1);
				curr.next = node;
				break;
			}
			curr = curr.next;
			curr.val += 1;
			flag = curr.val > 9;
			curr.val = flag ? curr.val % 10 : curr.val;
		}
		return root.next;
		// return transToLink(transToInt(l1) + transToInt(l2));
	}

	public static void main(String[] args) {
		// ListNode a = new ListNode(9);
		// ListNode b = new ListNode(9);
		AddTwoNumbers add = new AddTwoNumbers();
		ListNode a = add.transToLink(243);
		ListNode b = add.transToLink(564);
		ListNode sum = add.addTwoNumbers2(a, b);
		while (sum != null) {
			System.out.print(sum.val + "->");
			sum = sum.next;
		}
		// System.out.println(add.transToInt(sum));
	}
}
