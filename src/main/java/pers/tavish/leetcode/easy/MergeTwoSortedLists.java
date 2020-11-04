package pers.tavish.leetcode.easy;

import org.junit.Test;
import pers.tavish.leetcode.struct.ListNode;

/**

 Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

 Example 1:

 Input: l1 = [1,2,4], l2 = [1,3,4]
 Output: [1,1,2,3,4,4]

 Example 2:

 Input: l1 = [], l2 = []
 Output: []

 Example 3:

 Input: l1 = [], l2 = [0]
 Output: [0]

 Constraints:

 - The number of nodes in both lists is in the range [0, 50].
 - -100 <= Node.val <= 100
 - Both l1 and l2 are sorted in non-decreasing order.

 for more information: https://leetcode.com/problems/merge-two-sorted-lists/
 */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        System.out.println(mergeTwoLists(l1, l2));
    }
}
