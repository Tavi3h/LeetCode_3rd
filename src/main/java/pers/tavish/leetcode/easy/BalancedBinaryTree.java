package pers.tavish.leetcode.easy;

/*

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.


Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:

Input: root = []
Output: true

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-10^4 <= Node.val <= 10^4

for more information: https://leetcode.com/problems/balanced-binary-tree/
 */

import pers.tavish.leetcode.struct.TreeNode;

import java.util.Objects;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        } else {
            return isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        }
    }

    private int maxDepth(TreeNode root) {
        return Objects.isNull(root) ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}