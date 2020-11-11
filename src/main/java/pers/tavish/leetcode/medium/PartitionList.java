package pers.tavish.leetcode.medium;

/*

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

- Input: head = 1->4->3->2->5->2, x = 3
- Output: 1->2->2->4->3->5

for more information: https://leetcode.com/problems/partition-list/
 */

import pers.tavish.leetcode.struct.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        ListNode newDummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy, p = newDummy;
        while (curr.next != null) {
            if (curr.next.val < x) {
                p.next = curr.next;
                p = p.next;
                curr.next = curr.next.next;
                p.next = null;
            } else {
                curr = curr.next;
            }
        }
        p.next = dummy.next;
        return newDummy.next;
    }
}
