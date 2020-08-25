/*
494. 目标和
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。



示例：

输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。


提示：

数组非空，且长度不会超过 20 。
初始的数组的和不会超过 1000 。
保证返回的最终结果能被 32 位整数存下。
###解题思路
转化为0-1背包问题
执行用时：2 ms, 在所有 Java 提交中击败了99.98%的用户
内存消耗：37.7 MB, 在所有 Java 提交中击败了45.02%的用户
 */
package dp.目标和;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int target = 0;
        for (int i : nums) {
            target += i;
        }
        if (target < S) return 0;
        if ((target - S) % 2 != 0) return 0;
        target = (target - S) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}