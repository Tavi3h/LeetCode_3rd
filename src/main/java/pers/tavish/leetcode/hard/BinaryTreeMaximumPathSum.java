package pers.tavish.leetcode.hard;

/*

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: root = [1,2,3]
Output: 6

Example 2:

Input: root = [-10,9,20,null,null,15,7]
Output: 42

Constraints:

- The number of nodes in the tree is in the range [0, 3 * 104].
- -1000 <= Node.val <= 1000

for more information: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */

import pers.tavish.leetcode.struct.TreeNode;

import java.util.Objects;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int[] res = {Integer.MIN_VALUE};
        maxPathSum(root, res);
        return res[0];
    }

    private int maxPathSum(TreeNode node, int[] res) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int left = maxPathSum(node.left, res), right = maxPathSum(node.right, res);
        int cur = node.val + Math.max(left, 0) + Math.max(right, 0);
        res[0] = Math.max(res[0], cur);
        return node.val + Math.max(left, Math.max(right, 0));
    }
}
