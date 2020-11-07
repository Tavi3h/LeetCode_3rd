package pers.tavish.leetcode.medium;

/*

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

Constraints:

- intervals[i][0] <= intervals[i][1]

for more information: https://leetcode.com/problems/merge-intervals/
 */

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));

        LinkedList<int[]> res = new LinkedList<>();

        res.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] last = res.pop();
            if (interval[0] <= interval[1]) {
                res.push(new int[]{last[0], Math.max(last[1], interval[1])});
            } else {
                res.push(last);
                res.push(interval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
