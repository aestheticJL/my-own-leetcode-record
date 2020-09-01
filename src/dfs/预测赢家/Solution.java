/*
486. 预测赢家
给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。

给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。



示例 1：

输入：[1, 5, 2]
输出：False
解释：一开始，玩家1可以从1和2中进行选择。
如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
因此，玩家 1 永远不会成为赢家，返回 False 。
示例 2：

输入：[1, 5, 233, 7]
输出：True
解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
     最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。


提示：

1 <= 给定的数组长度 <= 20.
数组里所有分数都为非负数且不会大于 10000000 。
如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。
###解题思路
一、递归，注意当a取得时候是或运算，因为a会使他的分最大，而b取的时候是与运算，因为b也会使自己分数最大
执行用时：4 ms, 在所有 Java 提交中击败了14.14%的用户
内存消耗：37.3 MB, 在所有 Java 提交中击败了22.17%的用户

二、记忆化搜索
dp
执行用时：1 ms, 在所有 Java 提交中击败了53.83%的用户
内存消耗：36.9 MB, 在所有 Java 提交中击败了86.88%的用户
 */
package dfs.预测赢家;

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1, 0, 0, true) || dfs(nums, 0, nums.length - 1, 0, 0, true);
    }

    public boolean dfs(int[] piles, int left, int right, int a, int b, boolean isA) {
        if (left > right)
            return a >= b;
        if (isA)
            return dfs(piles, left + 1, right, a + piles[left], b, !isA) || dfs(piles, left, right - 1, a + piles[right], b, !isA);
        else
            return dfs(piles, left + 1, right, a, b + piles[left], !isA) && dfs(piles, left, right - 1, a, b + piles[right], !isA);
    }


    public boolean PredictTheWinner2(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }
}