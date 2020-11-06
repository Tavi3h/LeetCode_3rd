package pers.tavish.leetcode.medium;

/*

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:

- 1 <= nums.length <= 8
- -10 <= nums[i] <= 10

for more information: https://leetcode.com/problems/permutations-ii/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        permute(res, new ArrayList<>(), new boolean[nums.length], nums);
        return res;
    }

    private void permute(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(nums[i]);
                    permute(res, list, visited, nums);
                    list.remove(list.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    @Test
    public void testCase() {
        int[] nums = {1, 1, 2};
        System.out.println(permute(nums));
    }
}
