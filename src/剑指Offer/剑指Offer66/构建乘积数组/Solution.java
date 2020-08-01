/*
剑指 Offer 66. 构建乘积数组
给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。



示例:

输入: [1,2,3,4,5]
输出: [120,60,40,30,24]


提示：

所有元素乘积之和不会溢出 32 位整数
a.length <= 100000
###解题思路
先左到右乘一遍然后右到左一遍
执行用时：2 ms, 在所有 Java 提交中击败了83.39%的用户
内存消耗：52.5 MB, 在所有 Java 提交中击败了43.63%的用户

对于某个数i，他的res就是左右两边数的积L[i-1]*R[i+1]
执行用时：3 ms, 在所有 Java 提交中击败了12.45%的用户
内存消耗：52.6 MB, 在所有 Java 提交中击败了12.08%的用户
 */
package 剑指Offer.剑指Offer66.构建乘积数组;

import java.util.Arrays;

class Solution {
    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int[] b = new int[a.length];
        Arrays.fill(b, 1);
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int right = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            b[i] *= right;
            right *= a[i];
        }
        return b;
    }

    public int[] constructArr2(int[] a) {
        if (a.length == 0) return new int[0];
        if (a.length == 1) return new int[]{1};
        int[] L = new int[a.length];
        int[] R = new int[a.length];
        L[0] = a[0];
        R[a.length - 1] = a[a.length - 1];
        for (int i = 1; i < a.length - 1; i++) {
            L[i] = L[i - 1] * a[i];
            R[a.length - 1 - i] = R[a.length - 1 - i + 1] * a[a.length - 1 - i];
        }
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i == 0) b[i] = R[i + 1];
            else if (i == a.length - 1) b[i] = L[i - 1];
            else b[i] = L[i - 1] * R[i + 1];
        }
        return b;
    }
}