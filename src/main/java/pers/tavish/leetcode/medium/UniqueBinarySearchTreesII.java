package pers.tavish.leetcode.medium;

/*

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


Constraints:

- 0 <= n <= 8

for more information: https://leetcode.com/problems/unique-binary-search-trees-ii/
 */

import pers.tavish.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return n == 0 ? new ArrayList<>() : generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (right < left) {
            res.add(null);
        } else {
            for (int i = left; i <= right; i++) {
                List<TreeNode> lefts = generateTrees(left, i - 1), rights = generateTrees(i + 1, right);
                for (TreeNode treeNode : lefts) {
                    for (TreeNode node : rights) {
                        TreeNode root = new TreeNode(i);
                        root.left = treeNode;
                        root.right = node;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }
}
