/*
剑指 Offer 12. 矩阵中的路径
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。



示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
提示：

1 <= board.length <= 200
1 <= board[i].length <= 200
###解题思路
标准bfs
执行用时：8 ms, 在所有 Java 提交中击败了28.85%的用户
内存消耗：41.8 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer12.矩阵中的路径;

class Solution {
    int[][] run = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean flag;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0 || word == null) return true;
        flag = false;
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = '.';
                    dfs(board, word, i, j, 0);
                    board[i][j] = word.charAt(0);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void dfs(char[][] board, String word, int n, int m, int k) {
        k++;
        if (k < word.length()) {
            for (int i = 0; i < 4; i++) {
                if (flag) return;
                n += run[i][0];
                m += run[i][1];
                if (n >= 0 && n < board.length && m >= 0 && m < board[0].length && board[n][m] == word.charAt(k)) {
                    char temp = board[n][m];
                    board[n][m] = '.';
                    dfs(board, word, n, m, k);
                    board[n][m] = temp;
                }
                n -= run[i][0];
                m -= run[i][1];
            }
        } else {
            flag = true;
        }
    }
}