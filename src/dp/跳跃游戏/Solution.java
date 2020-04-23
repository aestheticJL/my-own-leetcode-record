 /*
 55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
###解题思路
使用动态规化即可，每一个点都判断所能达到的最大值

执行用时 :3 ms, 在所有 Java 提交中击败了36.96%的用户
内存消耗 :41.9 MB, 在所有 Java 提交中击败了12.50%的用户
  */
package dp.跳跃游戏;

class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i;j<nums.length&&j<=dp[i];j++){
                dp[i] = Math.max(dp[i], nums[j]+j);
                if (dp[i]>=nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}