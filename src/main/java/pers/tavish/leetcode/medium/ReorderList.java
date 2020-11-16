package pers.tavish.leetcode.medium;

/*

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

for more information: https://leetcode.com/problems/reorder-list/
 */

import org.junit.Assert;
import org.junit.Test;
import pers.tavish.leetcode.struct.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReorderList {
    public void reorderList(ListNode head) {
        Map<ListNode, ListNode> hm = new HashMap<>();
        ListNode curr = head, tail = null;
        while (Objects.nonNull(curr)) {
            if (Objects.isNull(curr.next)) {
                tail = curr;
                break;
            }
            hm.put(curr.next, curr);
            curr = curr.next;
        }
        curr = head;
        while (curr != tail && curr.next != tail) {
            tail.next = curr.next;
            curr.next = tail;
            curr = tail.next;
            tail = hm.get(tail);
            tail.next = null;
        }
    }
}
