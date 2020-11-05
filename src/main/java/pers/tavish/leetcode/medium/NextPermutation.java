package pers.tavish.leetcode.medium;

/*

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

Example 4:

Input: nums = [1]
Output: [1]

Constraints:

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 100

for more information: https://leetcode.com/problems/next-permutation/
 */

public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0)
            return;
        int i = num.length - 2;
        while (i >= 0 && num[i] >= num[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = i + 1;
            while (j < num.length && num[j] > num[i]) {
                j++;
            }
            j--;
            swap(num, i, j);
        }
        reverse(num, i + 1, num.length - 1);
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private void reverse(int[] num, int i, int j) {
        while (i < j) {
            swap(num, i++, j--);
        }
    }
}
