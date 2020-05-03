/*
最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
###解题思路
动态规化，dp[i]代表的是以i下标为结尾的最大和
执行用时 :1 ms, 在所有 Java 提交中击败了95.72%的用户
内存消耗 :40 MB, 在所有 Java 提交中击败了35.95%的用户
 */
package dp.最大字序和;

class Solution {
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] > (dp[i - 1] + nums[i]) ? nums[i] : (dp[i - 1] + nums[i]);
            result = dp[i] > result ? dp[i] : result;
        }
        return result;
    }
}