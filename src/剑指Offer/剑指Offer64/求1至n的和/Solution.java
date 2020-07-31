/*
剑指 Offer 64. 求1+2+…+n
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。



示例 1：

输入: n = 3
输出: 6
示例 2：

输入: n = 9
输出: 45


限制：

1 <= n <= 10000
###解题思路
短路做判断，递归做循环
执行用时：1 ms, 在所有 Java 提交中击败了62.62%的用户
内存消耗：36.7 MB, 在所有 Java 提交中击败了64.80%的用户
 */
package 剑指Offer.剑指Offer64.求1至n的和;

class Solution {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}