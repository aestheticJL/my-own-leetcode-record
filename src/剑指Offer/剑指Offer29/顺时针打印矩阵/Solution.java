/*
剑指 Offer 29. 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。



示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]


限制：

0 <= matrix.length <= 100
0 <= matrix[i].length <= 100
###解题思路
模拟即可
执行用时：1 ms, 在所有 Java 提交中击败了97.03%的用户
内存消耗：41.2 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer29.顺时针打印矩阵;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int up = 0;
        int under = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        while (true) {
            for (int i = left; i < matrix[0].length - right; i++) {
                res[count] = matrix[up][i];
                count++;
            }
            up++;
            if (up == matrix.length - under) {
                break;
            }
            for (int j = up; j < matrix.length - under; j++) {
                res[count] = matrix[j][matrix[0].length - 1 - right];
                count++;
            }
            right++;
            if (right == matrix[0].length - left) {
                break;
            }
            for (int k = matrix[0].length - 1 - right; k >= left; k--) {
                res[count] = matrix[matrix.length - 1 - under][k];
                count++;
            }
            under++;
            if (under == matrix.length - up) {
                break;
            }
            for (int l = matrix.length - 1 - under; l >= up; l--) {
                res[count] = matrix[l][left];
                count++;
            }
            left++;
            if (left == matrix[0].length - right) {
                break;
            }
        }
        return res;
    }
}