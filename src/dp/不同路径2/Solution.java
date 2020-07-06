/*
不同路径 II
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？



网格中的障碍物和空位置分别用 1 和 0 来表示。

说明：m 和 n 的值均不超过 100。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
###解题思路
dp
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了62.96%的用户
 */
package dp.不同路径2;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i = obstacleGrid.length;
        int j = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[i - 1][j - 1] == 1) return 0;
        int[][] dp = new int[i][j];
        dp[0][0] = 1;
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                if (obstacleGrid[k][l] == 1) continue;
                if (k == 0 && l == 0) continue;
                if (k == 0) {
                    dp[k][l] = dp[k][l - 1];
                } else if (l == 0) {
                    dp[k][l] = dp[k - 1][l];
                } else {
                    dp[k][l] = dp[k - 1][l] + dp[k][l - 1];
                }
            }
        }
        return dp[i - 1][j - 1];
    }
}