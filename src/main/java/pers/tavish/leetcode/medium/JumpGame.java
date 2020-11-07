package pers.tavish.leetcode.medium;

/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

- 1 <= nums.length <= 3 * 10^4
- 0 <= nums[i][j] <= 10^5

for more information: https://leetcode.com/problems/jump-game/
 */

public class JumpGame {
    public boolean canJump(int[] nums) {

        if (nums[0] >= nums.length - 1) {
            return true;
        }

        int curr = 0, currJump = nums[0];
        for (int i = curr; i <= currJump ; i++) {
            int maxJump = nums[i] + i;
            if (maxJump >= nums.length - 1) {
                return true;
            }
            currJump = Math.max(currJump, nums[i] + i);
        }
        return false;
    }
}
