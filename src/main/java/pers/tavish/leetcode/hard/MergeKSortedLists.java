package pers.tavish.leetcode.hard;

/*

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []

Constraints:

- k == lists.length
- 0 <= k <= 10^4
- 0 <= lists[i].length <= 500
- -10^4 <= lists[i][j] <= 10^4
- lists[i] is sorted in ascending order.
- The sum of lists[i].length won't exceed 10^4.

for more information: https://leetcode.com/problems/merge-k-sorted-lists/
 */

import org.junit.Test;
import pers.tavish.leetcode.struct.ListNode;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        return lists == null || lists.length == 0 ? null : mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int lo, int hi) {

        if (lo == hi) {
            return lists[lo];
        }

        int mid = lo + (hi - lo >>> 1);

        ListNode l1 = mergeKLists(lists, lo, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, hi);

        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    @Test
    public void testCase() {
        ListNode l1 = ListNode.build(1, 3, 4, 6, 7);
        ListNode l2 = ListNode.build(2, 3, 5, 8, 10);
        ListNode l3 = ListNode.build(4, 6, 9, 10, 13);
        System.out.println(mergeKLists(new ListNode[]{l1, l2, l3}));
    }
}
