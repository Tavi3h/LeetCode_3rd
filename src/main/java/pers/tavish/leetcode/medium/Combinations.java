package pers.tavish.leetcode.medium;

/*

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Example 2:

Input: n = 1, k = 1
Output: [[1]]

Constraints:

- 1 <= n <= 20
- 1 <= k <= n

for more information: https://leetcode.com/problems/combinations/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void combine(List<List<Integer>> res, List<Integer> es, int idx, int n, int k) {
        if (es.size() == k) {
            res.add(new ArrayList<>(es));
        } else {
            for (int i = idx; i <= n; i++) {
                es.add(i);
                combine(res, es, i + 1, n, k);
                es.remove(es.size() - 1);
            }
        }
    }

    @Test
    public void testCase() {
        System.out.println(combine(4, 2));
    }
}
