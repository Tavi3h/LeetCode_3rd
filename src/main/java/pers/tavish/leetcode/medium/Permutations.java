package pers.tavish.leetcode.medium;

/*

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

for more information: https://leetcode.com/problems/permutations/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
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
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
