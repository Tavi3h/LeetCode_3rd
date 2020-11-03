package pers.tavish.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**

 Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Notice that the solution set must not contain duplicate quadruplets.

 Example 1:

 Input: nums = [1,0,-1,0,-2,2], target = 0
 Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

 Example 2:

 Input: nums = [], target = 0
 Output: []

 Constraints:

 - 0 <= nums.length <= 200
 - -109 <= nums[i] <= 109
 - -109 <= target <= 109

 for more information: https://leetcode.com/problems/4sum
 */

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int key = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int m = j + 1, n = nums.length - 1;
                while (n > m) {
                    int sum = nums[j] + nums[m] + nums[n];
                    if (sum > key) {
                        --n;
                        while (m < n && nums[n] == nums[n + 1]) {
                            --n;
                        }
                    } else if (sum < key) {
                        ++m;
                        while (m < n && nums[m] == nums[m - 1]) {
                            ++m;
                        }
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[m++], nums[n--]));
                        while (m < n && nums[n] == nums[n + 1]) {
                            --n;
                        }
                        while (m < n && nums[m] == nums[m - 1]) {
                            ++m;
                        }
                    }
                }
            }
        }
        return list;
    }
}
