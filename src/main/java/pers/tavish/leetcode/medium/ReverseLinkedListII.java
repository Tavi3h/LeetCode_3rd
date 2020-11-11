package pers.tavish.leetcode.medium;

/*

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

for more information: https://leetcode.com/problems/reverse-linked-list-ii/
 */

import pers.tavish.leetcode.struct.ListNode;

import java.util.Objects;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode nodeM = dummy, nodeN = dummy;
        for (int i = 0; i < m - 1; i++) {
            nodeM = nodeM.next;
        }
        for (int i = 0; i < n; i++) {
            nodeN = nodeN.next;
        }

        ListNode p = nodeM.next, q = nodeN.next;
        nodeN.next = null;
        nodeM.next = reverse(p);
        p.next = q;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        ListNode p = head.next;
        head.next = null;
        ListNode q = reverse(p);
        p.next = head;
        return q;
    }
}
