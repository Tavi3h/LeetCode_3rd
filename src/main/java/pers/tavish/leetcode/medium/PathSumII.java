package pers.tavish.leetcode.medium;

/*

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

for more information: https://leetcode.com/problems/path-sum-ii/
 */

import pers.tavish.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (Objects.nonNull(root)) {
            pathSum(root, res, new ArrayList<>(), sum);
        }
        return res;
    }

    private void pathSum(TreeNode node, List<List<Integer>> res, List<Integer> list, int sum) {

        if (Objects.nonNull(node)) {
            list.add(node.val);
            if (sum == node.val && Objects.isNull(node.left) && Objects.isNull(node.right)) {
                res.add(new ArrayList<>(list));
            }
            pathSum(node.left, res, list, sum - node.val);
            pathSum(node.right, res, list, sum - node.val);
            list.remove(list.size() - 1);
        }
    }
}
