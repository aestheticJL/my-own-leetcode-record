/*
 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
###解题思路
dp见注解
执行用时：1 ms, 在所有 Java 提交中击败了99.40%的用户
内存消耗：38 MB, 在所有 Java 提交中击败了33.33%的用户
 */
package dp.最佳买卖股票时机含冷冻期;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        //今日结束后的状态：0冷冻状态，1持有股票状态，2无股票状态
        int[][] dp = new int[3][prices.length];
        dp[1][0] = -prices[0];//第一天结束只能进入有股或者无股
        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = dp[1][i - 1] + prices[i];//今日进入冷冻，必然是昨日有股
            dp[1][i] = Math.max(dp[2][i - 1] - prices[i], dp[1][i - 1]);//今日有股，要么昨日有股，要么昨日无股
            dp[2][i] = Math.max(dp[0][i - 1], dp[2][i - 1]);//今日无股，要么昨日进入冷冻，要么昨日无股
        }
        return Math.max(dp[0][prices.length - 1], dp[2][prices.length - 1]);
    }
}