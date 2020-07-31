/*
剑指 Offer 60. n个骰子的点数
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。



你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。



示例 1:

输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
示例 2:

输入: 2
输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]


限制：

1 <= n <= 11
###解题思路
dp
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37.6 MB, 在所有 Java 提交中击败了77.10%的用户
 */
package 剑指Offer.剑指Offer60.n个骰子的点数;

class Solution {
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][n * 6 + 1];
        //初始化
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        //i个骰子，投出的情况总是i-1个骰子投出的情况分别加上1-6
        for (int i = 2; i < n + 1; i++) {
            for (int j = i - 1; j <= 6 * (i - 1); j++) {
                for (int k = 1; k <= 6; k++) {
                    dp[i][dp[i - 1][j] + k] += dp[i - 1][j];
                }
            }
        }
        double[] res = new double[n * 5 + 1];
        double sum = Math.pow(6, n);
        for (int i = 0; i < res.length; i++) {
            System.out.println(dp[n][i + n]);
            res[i] = dp[n][i + n] / sum;
        }
        return res;
    }
}