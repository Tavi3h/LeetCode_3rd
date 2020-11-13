package pers.tavish.leetcode.easy;

/*

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5


Constraints:

- The number of nodes in the tree is in the range [0, 105].
- -1000 <= Node.val <= 1000

for more information: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */

import pers.tavish.leetcode.struct.TreeNode;

import java.util.Objects;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int l = minDepth(root.left), r = minDepth(root.right);
        return l == 0 || r == 0 ? 1 + l + r : 1 + Math.min(l, r);
    }
}
