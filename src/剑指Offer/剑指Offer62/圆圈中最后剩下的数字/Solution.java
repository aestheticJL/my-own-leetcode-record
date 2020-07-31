/*
剑指 Offer 62. 圆圈中最后剩下的数字
0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。



示例 1：

输入: n = 5, m = 3
输出: 3
示例 2：

输入: n = 10, m = 17
输出: 2


限制：

1 <= n <= 10^5
1 <= m <= 10^6
###解题思路
模拟
执行用时：1071 ms, 在所有 Java 提交中击败了19.96%的用户
内存消耗：41.6 MB, 在所有 Java 提交中击败了23.60%的用户
 */
package 剑指Offer.剑指Offer62.圆圈中最后剩下的数字;

import java.util.ArrayList;

class Solution {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int temp = 0;
        while (n > 1) {
            temp = (temp + m - 1) % n;
            list.remove(temp);
            n--;
        }
        return list.get(0);
    }
}