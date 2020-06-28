/*
长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。

示例:

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
###解题思路
双指针
执行用时：2 ms, 在所有 Java 提交中击败了83.23%的用户
内存消耗：39.8 MB, 在所有 Java 提交中击败了6.67%的用户
 */
package array.长度最小的子数组;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int begin = 0;
        int end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                res = Math.min(res, end - begin + 1);
                sum -= nums[begin];
                begin++;
            }
            end++;
        }
        if (res == Integer.MAX_VALUE) return 0;
        return res;
    }
}