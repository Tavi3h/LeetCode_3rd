package pers.tavish.leetcode.medium;

/*

Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

Example 2:

Input: head = []
Output: []

Example 3:

Input: head = [0]
Output: [0]

Example 4:

Input: head = [1,3]
Output: [3,1]

Constraints:

- The number of nodes in head is in the range [0, 2 * 104].
- -10^5 <= Node.val <= 10^5

for more information: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */

import pers.tavish.leetcode.struct.ListNode;
import pers.tavish.leetcode.struct.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {

        if (head == tail) {
            return null;
        }

        ListNode slow = head;
        for (ListNode fast = head; fast != tail && tail != fast.next; fast = fast.next.next) {
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }
}
