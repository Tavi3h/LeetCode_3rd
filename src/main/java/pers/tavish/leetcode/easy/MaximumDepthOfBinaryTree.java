package pers.tavish.leetcode.easy;

/*

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

for more information: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

import pers.tavish.leetcode.struct.TreeNode;

import java.util.Objects;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return Objects.isNull(root) ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
