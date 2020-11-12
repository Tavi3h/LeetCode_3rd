package pers.tavish.leetcode.easy;

/*

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

for more information: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

import pers.tavish.leetcode.struct.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return new TreeNode(nums[lo]);
        }

        int mid = lo + (hi - lo >>> 1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, lo, mid-1);
        node.right = sortedArrayToBST(nums, mid + 1, hi);
        return node;
    }
}
