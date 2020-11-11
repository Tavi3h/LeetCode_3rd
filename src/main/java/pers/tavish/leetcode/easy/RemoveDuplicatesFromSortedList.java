package pers.tavish.leetcode.easy;

/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2

Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

for more information: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

import pers.tavish.leetcode.struct.ListNode;

import java.util.Objects;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode slow = head, fast = head;
        while (Objects.nonNull(fast)) {
            if (slow.val == fast.val) {
                fast = fast.next;
            } else {
                slow.next = fast;
                slow = slow.next;
            }
        }
        slow.next = fast;
        return dummy.next;
    }
}
