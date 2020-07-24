/*
除数博弈
爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。

最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：

选出任一 x，满足 0 < x < N 且 N % x == 0 。
用 N - x 替换黑板上的数字 N 。
如果玩家无法执行这些操作，就会输掉游戏。

只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。



示例 1：

输入：2
输出：true
解释：爱丽丝选择 1，鲍勃无法进行操作。
示例 2：

输入：3
输出：false
解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。


提示：

1 <= N <= 1000
###解题思路
DP
执行用时：6 ms, 在所有 Java 提交中击败了16.95%的用户
内存消耗：36.1 MB, 在所有 Java 提交中击败了10.00%的用户
 */
package dp.除数博弈;

class Solution {
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        for (int i = 2; i < dp.length; i++) {
            int x = 1;
            boolean flag = false;
            while (i > x) {
                if (i % x == 0 && dp[i - x] == false) {
                    flag = true;
                    break;
                }
                x++;
            }
            dp[i] = flag;
        }
        return dp[N];
    }
}