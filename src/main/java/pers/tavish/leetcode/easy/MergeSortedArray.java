package pers.tavish.leetcode.easy;

/*

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]


Constraints:

- -10^9 <= nums1[i], nums2[i] <= 10^9
- nums1.length == m + n
- nums2.length == n

for more information: https://leetcode.com/problems/merge-sorted-array/
 */

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] aux = new int[nums1.length];
        System.arraycopy(nums1, 0, aux, 0, nums1.length);
        int i = 0, j = 0;
        for (int k = 0; k < nums1.length; k++) {
            if (i >= m) {
                nums1[k] = nums2[j++];
            } else if (j >= n) {
                nums1[k] = aux[i++];
            } else if (aux[i] < nums2[j]) {
                nums1[k] = aux[i++];
            } else {
                nums1[k] = nums2[j++];
            }
        }
    }
}
