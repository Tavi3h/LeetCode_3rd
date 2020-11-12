package pers.tavish.leetcode.medium;

/*

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

for more information: https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

import pers.tavish.leetcode.struct.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (Objects.nonNull(root)) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> es = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    es.add(node.val);
                    if (Objects.nonNull(node.left)) {
                        queue.add(node.left);
                    }
                    if (Objects.nonNull(node.right)) {
                        queue.add(node.right);
                    }
                }
                res.add(es);
            }
        }
        return res;
    }
}
