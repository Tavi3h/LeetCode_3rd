package pers.tavish.leetcode.easy;

/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

for more information: https://leetcode.com/problems/symmetric-tree/
 */

import pers.tavish.leetcode.struct.TreeNode;

import java.util.Objects;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return Objects.isNull(root) || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        } else if (Objects.isNull(p) || Objects.isNull(q)) {
            return false;
        } else {
            return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        }
    }
}
