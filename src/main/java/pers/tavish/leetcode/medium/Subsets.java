package pers.tavish.leetcode.medium;

/*

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

for more information: https://leetcode.com/problems/subsets/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (Objects.nonNull(nums) && nums.length != 0) {
            subsets(res, new ArrayList<>(), nums, 0);
        }
        return res;
    }

    private void subsets(List<List<Integer>> res, List<Integer> list, int[] nums, int level) {
        res.add(new ArrayList<>(list));
        for (int i = level; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
