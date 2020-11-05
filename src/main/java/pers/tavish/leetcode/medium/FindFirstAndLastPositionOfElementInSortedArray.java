package pers.tavish.leetcode.medium;

/*

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

Constraints:

- 0 <= nums.length <= 105
- -109 <= nums[i] <= 109
- nums is a non-decreasing array.
- -109 <= target <= 109

for more information: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (i < 0) {
            return new int[]{-1, -1};
        }
        int left = i - 1, right = i + 1;
        while (left >= 0) {
            if (nums[left] == target) {
                left--;
            } else {
                break;
            }
        }
        while (right < nums.length) {
            if (nums[right] == target) {
                right++;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right - 1};
    }
}
