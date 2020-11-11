package pers.tavish.leetcode.medium;

/*

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

for more information: https://leetcode.com/problems/subsets-ii/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (Objects.nonNull(nums) && nums.length != 0) {
            Arrays.sort(nums);
            subsetsWithDup(res, new ArrayList<>(), nums, 0);
        }
        return res;
    }

    private void subsetsWithDup(List<List<Integer>> res, List<Integer> list, int[] nums, int level) {
        res.add(new ArrayList<>(list));
        for (int i = level; i < nums.length; i++) {
            if (i > level && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsWithDup(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
