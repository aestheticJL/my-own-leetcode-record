/*
面试题46. 把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。



示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"


提示：

0 <= num < 231
###解题思路
动态规化，约等于上台阶，不过需要考虑0的情况，所以稍微复杂了一些
执行用时 :1 ms, 在所有 Java 提交中击败了22.29%的用户
内存消耗 :36.5 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package dp.把数字翻译成字符串;

class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        if (s.length() < 2) return 1;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        String begin = s.substring(0, 2);
        Integer integer = Integer.valueOf(begin);
        if ("0".equals(s.substring(0, 1)) || integer > 25) {
            dp[2] = 1;
        } else {
            dp[2] = 2;
        }
        for (int i = 3; i < dp.length; i++) {
            String temp = s.substring(i - 2, i);
            Integer integerTemp = Integer.valueOf(temp);
            if ("0".equals(s.substring(i - 2, i - 1)) || integerTemp > 25) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}