package pers.tavish.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**

 Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 Example 1:

 Input: nums = [-1,2,1,-4], target = 1
 Output: 2
 Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


 Constraints:

 - 3 <= nums.length <= 10^3
 - -10^3 <= nums[i] <= 10^3
 - -10^4 <= target <= 10^4

 for more information: https://leetcode.com/problems/3sum-closest/
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int m = i + 1, n = nums.length - 1;
            while (m < n) {
                int sum = nums[i] + nums[m] + nums[n];
                int curDis = Math.abs(target - sum);
                if (curDis < distance) {
                    distance = curDis;
                    closest = sum;
                }
                if (target - sum > 0) {
                    ++m;
                } else {
                    --n;
                }
            }
        }
        return closest;
    }
}
