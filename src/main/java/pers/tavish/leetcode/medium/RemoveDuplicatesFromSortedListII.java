package pers.tavish.leetcode.medium;

/*

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the linked list sorted as well.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5

Example 2:

Input: 1->1->1->2->3
Output: 2->3

for more information: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

import pers.tavish.leetcode.struct.ListNode;

import java.util.Objects;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), tmp = dummy, curr = head;
        int cnt = 1;
        while (Objects.nonNull(curr)) {
            curr = curr.next;
            if (Objects.nonNull(curr) && curr.val == head.val) {
                cnt++;
            } else {
                if (cnt > 1) {
                    cnt = 1;
                } else {
                    tmp.next = head;
                    tmp = tmp.next;
                }
                head = curr;
            }
        }
        tmp.next = null;
        return dummy.next;
    }
}
