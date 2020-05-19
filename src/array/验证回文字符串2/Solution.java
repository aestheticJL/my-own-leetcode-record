/*
 验证回文字符串 Ⅱ
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True
示例 2:

输入: "abca"
输出: True
解释: 你可以删除c字符。
注意:

字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
###解题思路
经典双指针，多一个错误判断
执行用时 :6 ms, 在所有 Java 提交中击败了99.84%的用户
内存消耗 :40.2 MB, 在所有 Java 提交中击败了6.67%的用户
 */
package array.验证回文字符串2;

class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int flag = 1;
        return valid(left, right, s, flag);
    }

    public static boolean valid(int left, int right, String s, int flag) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else if (flag > 0) {
                return valid(left + 1, right, s, 0) || valid(left, right - 1, s, 0);
            } else {
                return false;
            }
        }
        return true;
    }
}