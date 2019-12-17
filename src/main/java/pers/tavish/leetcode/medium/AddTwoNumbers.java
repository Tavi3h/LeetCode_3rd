package pers.tavish.leetcode.medium;

/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

for more information: https://leetcode.com/problems/add-two-numbers/description/
 */

import org.junit.Test;
import pers.tavish.leetcode.struct.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), head = dummy;
        int step = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + step;
            step = 0;
            if (sum > 9) {
                sum -= 10;
                step = 1;
            }
            head.next = new ListNode(sum);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode tmp = l1 == null ? l2 : l1;
        while (tmp != null) {
            int val = tmp.val + step;
            step = 0;
            if (val >= 10) {
                val -= 10;
                step = 1;
            }
            head.next = new ListNode(val);
            head = head.next;
            tmp = tmp.next;
        }
        if (step == 1) {
            head.next = new ListNode(step);
        }
        return dummy.next;
    }

    @Test
    public void testCase() {
        ListNode head1 = ListNode.build(2, 4, 3);
        ListNode head2 = ListNode.build(5, 6, 4);
        System.out.println(addTwoNumbers(head1, head2));
    }
}
