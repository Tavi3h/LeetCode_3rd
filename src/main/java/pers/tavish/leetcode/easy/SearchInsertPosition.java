package pers.tavish.leetcode.easy;

/*

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

Example 4:

Input: nums = [1,3,5,6], target = 0
Output: 0

Example 5:

Input: nums = [1], target = 0
Output: 0

Constraints:

- 1 <= nums.length <= 104
- -104 <= nums[i] <= 104
- nums contains distinct values sorted in ascending order.
- -104 <= target <= 104

for more information: https://leetcode.com/problems/search-insert-position/
 */

import org.junit.Test;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo >>> 1);
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    /*

    public int searchInsert(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);
        return pos < 0 ? -pos - 1 : pos;
    }

     */

    @Test
    public void testCase() {
        int[] arr = {1, 3, 5, 6};
        System.out.println(searchInsert(arr, 0));
    }
}
