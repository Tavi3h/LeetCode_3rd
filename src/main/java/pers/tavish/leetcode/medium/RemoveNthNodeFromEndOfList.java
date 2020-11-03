package pers.tavish.leetcode.medium;

import org.junit.Test;
import pers.tavish.leetcode.struct.ListNode;

/**

 Given the head of a linked list, remove the nth node from the end of the list and return its head.

 Follow up: Could you do this in one pass?

 Example 1:

 Input: head = [1,2,3,4,5], n = 2
 Output: [1,2,3,5]

 Example 2:

 Input: head = [1], n = 1
 Output: []

 Example 3:

 Input: head = [1,2], n = 1
 Output: [1]

 for more information: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode fast = dummy, slow = dummy;
        dummy.next = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    @Test
    public void testCase() {
        ListNode list = ListNode.build(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(removeNthFromEnd(list, 1));
    }
}
