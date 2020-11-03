package pers.tavish.leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * - 0 <= nums.length <= 3000
 * - -105 <= nums[i] <= 105
 * <p>
 * for more information: https://leetcode.com/problems/3sum/
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[k], nums[i++], nums[j--]));
                    while (j > i && nums[j] == nums[j + 1]) {
                        j--;
                    }
                    while (j > i && nums[i] == nums[i - 1]) {
                        i++;
                    }
                } else if (sum > 0) {
                    j--;
                    while (j > i && nums[j] == nums[j + 1]) {
                        j--;
                    }
                } else {
                    i++;
                    while (j > i && nums[i] == nums[i - 1]) {
                        i++;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void testCase() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
