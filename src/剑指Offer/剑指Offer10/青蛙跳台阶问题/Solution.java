/*
剑指 Offer 10- II. 青蛙跳台阶问题
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
提示：

0 <= n <= 100
###解题思路
dp
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：36.4 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer10.青蛙跳台阶问题;

class Solution {
    public int numWays(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % (1000000007 - 1);
        }
        return dp[n];
    }
}