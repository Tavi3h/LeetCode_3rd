package pers.tavish.leetcode.hard;

/*

Given an unsorted integer array nums, find the smallest missing positive integer.

Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1

Constraints:

- 0 <= nums.length <= 300
- -2^31 <= nums[i] <= 2^31 - 1

for more information: https://leetcode.com/problems/first-missing-positive/
 */

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        Arrays.sort(nums);

        int pos = Arrays.binarySearch(nums, 1);
        if (pos < 0) {
            return 1;
        }

        int temp1 = 1, temp2 = 2;
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] == temp1) {
                continue;
            } else if (nums[i] == temp2) {
                temp1++;
                temp2++;
            } else {
                break;
            }
        }
        return temp2;
    }
}
