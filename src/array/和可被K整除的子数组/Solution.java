/*
和可被 K 整除的子数组
给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。



示例：

输入：A = [4,5,0,-2,-3,1], K = 5
输出：7
解释：
有 7 个子数组满足其元素之和可被 K = 5 整除：
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]


提示：

1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000
###解题思路
前缀和，dp[i] 表示余数为i数组个数
执行用时 :5 ms, 在所有 Java 提交中击败了69.45%的用户
内存消耗 :43.1 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package array.和可被K整除的子数组;

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] dp = new int[K];
        int sum = 0;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int temp = sum % K;
            if (temp < 0) temp += K;
            if (temp == 0) res++;
            res += dp[temp];
            dp[temp]++;
        }
        return res;
    }
}