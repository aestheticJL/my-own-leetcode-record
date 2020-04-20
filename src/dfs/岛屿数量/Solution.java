/*
200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

示例 1:

输入:
11110
11010
11000
00000
输出: 1
示例 2:

输入:
11000
11000
00100
00011
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

###解题思路
dfs和bfs皆可，选择了实现比较方便的dfs
执行用时 :
2 ms, 在所有 Java 提交中击败了96.16%的用户
内存消耗 :41.9 MB, 在所有 Java 提交中击败了6.25%的用户
 */
package dfs.岛屿数量;

class Solution {
    public static int[][] run = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void bfs(int[][] vis, char[][] grid, int i, int j) {
        vis[i][j] = 1;
        for (int r = 0; r < 4; r++) {
            int newI = i + run[r][0];
            int newJ = j + run[r][1];
            if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && vis[newI][newJ] == 0 && grid[newI][newJ] == '1') {
                bfs(vis, grid, newI, newJ);
            }
        }
        return;
    }

    public int numIslands(char[][] grid) {
        int sum = 0;
        if (grid.length == 0 || grid == null) {
            return sum;
        }
        int vis[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    bfs(vis, grid, i, j);
                    sum++;
                }
            }
        }
        return sum;
    }
}