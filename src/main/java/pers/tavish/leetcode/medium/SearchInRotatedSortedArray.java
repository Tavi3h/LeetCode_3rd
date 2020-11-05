package pers.tavish.leetcode.medium;

/*

You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

- 1 <= nums.length <= 5000
- -10^4 <= nums[i] <= 10^4
- All values of nums are unique.
- nums is guranteed to be rotated at some pivot.
- -10^4 <= target <= 10^4

for more information: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {

        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo >>> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[hi]) {
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (nums[lo] <= target && nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }
}
