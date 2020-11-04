package pers.tavish.leetcode.medium;

/*

Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes. Only nodes itself may be changed.

Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:

Input: head = []
Output: []

Example 3:

Input: head = [1]
Output: [1]

Constraints:

- The number of nodes in the list is in the range [0, 100].
- 0 <= Node.val <= 100

for more information: https://leetcode.com/problems/swap-nodes-in-pairs/
 */

import org.junit.Test;
import pers.tavish.leetcode.struct.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode k = dummy;
        while (k.next != null && k.next.next != null) {
            ListNode m = k.next, n = k.next.next;
            k.next = n;
            m.next = n.next;
            n.next = m;
            k = k.next.next;
        }
        return dummy.next;
    }

    @Test
    public void testCase() {
        ListNode head = ListNode.build(1, 2, 3, 4, 5);
        System.out.println(swapPairs(head));
    }
}
