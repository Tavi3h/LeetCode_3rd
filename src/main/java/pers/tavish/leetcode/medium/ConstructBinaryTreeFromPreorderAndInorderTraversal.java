package pers.tavish.leetcode.medium;

import pers.tavish.leetcode.struct.TreeNode;

/*

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

for more information: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        int rootVal = pre[preStart], rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pre, preStart + 1, preStart + len, in, inStart, rootIndex - 1);
        root.right = buildTree(pre, preStart + len + 1, preEnd, in, rootIndex + 1, inEnd);
        return root;
    }
}
