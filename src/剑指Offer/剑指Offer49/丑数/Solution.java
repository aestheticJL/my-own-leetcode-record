/*
剑指 Offer 49. 丑数
我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。



示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:

1 是丑数。
n 不超过1690。
###解题思路
dp
执行用时：3 ms, 在所有 Java 提交中击败了78.47%的用户
内存消耗：37.7 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer49.丑数;

class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 6) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        int two = 0, three = 0, five = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[two] * 2, dp[three] * 3), dp[five] * 5);
            if (dp[two] * 2 == dp[i]) two++;
            if (dp[three] * 3 == dp[i]) three++;
            if (dp[five] * 5 == dp[i]) five++;
        }
        return dp[n - 1];
    }
}