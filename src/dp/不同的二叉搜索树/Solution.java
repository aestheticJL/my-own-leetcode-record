/*
不同的二叉搜索树
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
###解题思路
动态规化，对于n=i，以每个数字j为节点，左右分别是j-1和i-j的子树。
dp[]存储的是给一个整数n能构成的二叉树种数
temp[]存储的是对于整数n，以i为根的二叉树种数
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：36.5 MB, 在所有 Java 提交中击败了7.69%的用户
 */
package dp.不同的二叉搜索树;

class Solution {
    public int numTrees(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int[] temp = new int[i + 1];
            for (int j = 1; j < i + 1; j++) {
                temp[j] = dp[j - 1] * dp[i - j];
                dp[i] += temp[j];
            }
        }
        return dp[n];
    }
}