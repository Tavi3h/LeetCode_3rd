package pers.tavish.leetcode.medium;

/*

Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

Example 4:

Input: root = [1,2]
Output: [2,1]

Example 5:

Input: root = [1,null,2]
Output: [2,1]

Constraints:

- The number of the nodes in the tree is in the range [0, 100].
- -100 <= Node.val <= 100

Follow up:

Recursive solution is trivial, could you do it iteratively?

for more information: https://leetcode.com/problems/binary-tree-postorder-traversal/
 */

import pers.tavish.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (Objects.nonNull(root)) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                res.add(0, node.val);
                if (Objects.nonNull(node.left)) {
                    stack.push(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    stack.push(node.right);
                }
            }
        }
        return res;
    }
}
