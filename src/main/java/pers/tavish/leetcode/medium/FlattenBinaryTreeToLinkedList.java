package pers.tavish.leetcode.medium;

/*

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

for more information: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */

import pers.tavish.leetcode.struct.TreeNode;

import java.util.Objects;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (Objects.nonNull(curr)) {
            if (Objects.nonNull(curr.left)) {
                TreeNode p = curr.left;
                while (Objects.nonNull(p.right)) {
                    p = p.right;
                }
                p.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
