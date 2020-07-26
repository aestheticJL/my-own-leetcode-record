/*
剑指 Offer 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？



示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20
###解题思路
基本bfs
执行用时：7 ms, 在所有 Java 提交中击败了16.45%的用户
内存消耗：37.1 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer13.机器人的运动范围;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int sum;
    int[][] run = new int[][]{{0, 1}, {1, 0}};

    public int movingCount(int m, int n, int k) {
        sum = 0;
        int[][] map = new int[m][n];
        map[0][0] = 1;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            sum++;
            int i = poll[0];
            int j = poll[1];
            for (int r = 0; r < 2; r++) {
                i += run[r][0];
                j += run[r][1];
                if (i < m && j < n && i >= 0 && j >= 0 && compute(i, j) <= k && map[i][j] == 0) {
                    map[i][j] = 1;
                    queue.offer(new int[]{i, j});
                }
                i -= run[r][0];
                j -= run[r][1];
            }
        }
        return sum;
    }

    public int compute(int i, int j) {
        int sum = 0;
        while (i / 10 > 0) {
            sum += i % 10;
            i /= 10;
        }
        sum += i;
        while (j / 10 > 0) {
            sum += j % 10;
            j /= 10;
        }
        sum += j;
        return sum;
    }
}