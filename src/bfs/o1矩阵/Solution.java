/*
542. 01 矩阵
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1:
输入:

0 0 0
0 1 0
0 0 0
输出:

0 0 0
0 1 0
0 0 0
示例 2:
输入:

0 0 0
0 1 0
1 1 1
输出:

0 0 0
0 1 0
1 2 1
注意:

给定矩阵的元素个数不超过 10000。
给定矩阵中至少有一个元素是 0。
矩阵中的元素只在四个方向上相邻: 上、下、左、右。
###解题思路
采用bfs即可
 */
package bfs.o1矩阵;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int[][] run = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) continue;
                int[][] updateMatrix = new int[matrix.length][matrix[0].length];
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                matrix[i][j] = bfs(matrix, queue, updateMatrix);
            }
        }
        return matrix;
    }

    public static Integer bfs(int[][] matrix, Queue<int[]> queue, int[][] updateMatrix) {
        while (!queue.isEmpty()) {
            int[] tempInts = queue.poll();
            int x = tempInts[0];
            int y = tempInts[1];
            int temp = updateMatrix[x][y] + 1;
            for (int r = 0; r < 4; r++) {
                int newX = x + run[r][0];
                int newY = y + run[r][1];
                if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && updateMatrix[newX][newY] == 0) {
                    if (matrix[newX][newY] == 0) {
                        return temp;
                    }
                    updateMatrix[newX][newY] = temp;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return 0;
    }
}