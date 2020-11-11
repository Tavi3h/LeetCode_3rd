package pers.tavish.leetcode.hard;

/*

You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

Example 1:

Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:

Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.

for more information: https://leetcode.com/problems/recover-binary-search-tree/
 */

import pers.tavish.leetcode.struct.TreeNode;

public class RecoverBinarySearchTree {

    private TreeNode pre, first, second;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void inOrder(TreeNode node) {

        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (pre != null && pre.val > node.val) {
            if (first == null) {
                first = pre;
            }
            second = node;
        }
        pre = node;
        inOrder(node.right);
    }
}
