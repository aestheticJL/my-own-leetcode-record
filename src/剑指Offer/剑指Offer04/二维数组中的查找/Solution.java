/*
剑指 Offer 04. 二维数组中的查找
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。



示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。



限制：

0 <= n <= 1000

0 <= m <= 1000
###解题思路
矩阵本质上是以右下角为根的二叉搜索树
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：45.6 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer04.二维数组中的查找;

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = 0;
        while (m > 0 && n < matrix[0].length) {
            if (matrix[m][n] == target) return true;
            if (matrix[m][n] < target) {
                n++;
                continue;
            } else {
                m++;
                continue;
            }
        }
        return false;
    }
}