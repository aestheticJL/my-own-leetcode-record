/*
 最佳观光组合
给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。

一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。

返回一对观光景点能取得的最高分。



示例：

输入：[8,1,5,2,6]
输出：11
解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11


提示：

2 <= A.length <= 50000
1 <= A[i] <= 1000
###解题思路
本质上是数学题，结果res = A[i]-i+A[j]+j 遍历i的时候，可以顺便计算A[j]+j的最大值
执行用时 :4 ms, 在所有 Java 提交中击败了87.77%的用户
内存消耗 :48.3 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package array.最佳观光组合;

class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int res = A[1] - 1 + A[0] + 0;
        int max = A[0] + 0;
        for (int i = 2; i < A.length; i++) {
            max = Math.max(max, A[i - 1] + (i - 1));
            res = Math.max(res, A[i] - i + max);
        }
        return res;
    }
}