/*
415. 字符串相加
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：

num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
###解题思路
模拟
执行用时：2 ms, 在所有 Java 提交中击败了99.89%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了79.51%的用户
 */
package string.字符串相加;

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int pre = 0;
        while (n1 >= 0 || n2 >= 0 || pre > 0) {
            if (n1 >= 0) pre += num1.charAt(n1--) - '0';
            if (n2 >= 0) pre += num2.charAt(n2--) - '0';
            sb.append(pre % 10);
            pre /= 10;
        }
        return sb.reverse().toString();
    }
}