/*
 跳跃游戏 II
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。
###解题思路
dp，无优化，dp[i]记录到达该点的最小跳跃次数，如为max_value-1则为无法到达
执行用时 :500 ms, 在所有 Java 提交中击败了5.01%的用户
内存消耗 :41.5 MB, 在所有 Java 提交中击败了5.00%的用户
 */
package dp.跳跃游戏II;

import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= i + nums[i]; j++) {
                if (j < nums.length) dp[j] = Math.min(dp[i] + 1, dp[j]);
                else break;
            }
        }
        return dp[nums.length - 1];
    }
}