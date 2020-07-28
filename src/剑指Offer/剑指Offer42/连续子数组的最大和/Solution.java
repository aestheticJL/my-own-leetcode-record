/*
剑指 Offer 42. 连续子数组的最大和
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。



示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。


提示：

1 <= arr.length <= 10^5
-100 <= arr[i] <= 100
###解题思路
动态规化+滑动窗口
执行用时：1 ms, 在所有 Java 提交中击败了99.16%的用户
内存消耗：46.5 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer42.连续子数组的最大和;

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) max = nums[i];
            else {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}