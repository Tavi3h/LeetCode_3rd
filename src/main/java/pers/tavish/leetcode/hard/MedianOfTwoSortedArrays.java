package pers.tavish.leetcode.hard;

/*

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

for more information: https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

public class MedianOfTwoSortedArrays {

    // O(log(m+n))
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//
//        int x = nums1.length, y = nums2.length;
//        int low = 0, high = x;
//
//        while (low <= high) {
//            int partitionX = (low + high) / 2;
//            int partitionY = (x + y + 1) / 2 - partitionX;
//
//            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
//            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
//
//            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
//            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
//
//            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
//                if ((x + y) % 2 == 0) {
//                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
//                } else {
//                    return Math.max(maxLeftX, maxLeftY);
//                }
//            } else if (minRightX < maxLeftY) {
//                low = partitionX + 1;
//            } else {
//                high = partitionX - 1;
//            }
//        }
//        throw new RuntimeException();
//    }

    // O(n+m)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (i == nums1.length) {
                nums[k] = nums2[j++];
            } else if (j == nums2.length) {
                nums[k] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i++];
            } else {
                nums[k] = nums2[j++];
            }
        }
        return nums.length % 2 == 0 ? (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2d : nums[nums.length / 2];
    }
}
