/*
剑指 Offer 33. 二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。



参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true


提示：

数组长度 <= 1000
###解题思路
递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37.2 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer33.二叉搜索树的后序遍历序列;

import java.util.Arrays;

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1 || postorder == null) return true;
        int midValue = postorder[postorder.length - 1];
        int i = 0;
        for (; i < postorder.length - 1; i++) {
            if (postorder[i] > midValue) break;
        }
        for (int j = i; j < postorder.length - 1; j++) {
            if (postorder[j] <= midValue) return false;
        }
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, i)) && verifyPostorder(Arrays.copyOfRange(postorder, i, postorder.length - 1));
    }
}