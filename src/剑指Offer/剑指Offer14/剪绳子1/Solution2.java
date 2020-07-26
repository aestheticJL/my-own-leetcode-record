/*
剑指 Offer 14- I. 剪绳子
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：

2 <= n <= 58
###解题思路
数学法，分段为3为最优
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：36.5 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer14.剪绳子1;

class Solution2 {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int count = n / 3;
        int res = 1;
        while (count > 0) {
            res *= 3;
            count--;
        }
        int temp = n % 3;
        if (temp == 0) {
            return res;
        } else if (temp == 1) {
            return res / 3 * 4;
        } else {
            return res * 2;
        }
    }
}