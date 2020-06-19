/*
验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
###解题思路
典中典的题目
执行用时：2 ms, 在所有 Java 提交中击败了99.91%的用户
内存消耗：39.8 MB, 在所有 Java 提交中击败了7.14%的用户 */
package string.验证回文串;

class Solution {
    public boolean isPalindrome(String s) {
        int right = s.length() - 1;
        int left = 0;
        while (left < right) {
            char l = s.charAt(left);
            if (!((l >= '0' && l <= '9') || (l >= 'A' && l <= 'Z') || (l >= 'a' && l <= 'z'))) {
                left++;
                continue;
            }
            char r = s.charAt(right);
            if (!((r >= '0' && r <= '9') || (r >= 'A' && r <= 'Z') || (r >= 'a' && r <= 'z'))) {
                right--;
                continue;
            }
            if (l > 'Z' && l <= 'z') l -= 32;
            if (r > 'Z' && r <= 'z') r -= 32;
            if (l != r) return false;
            left++;
            right--;
        }
        return true;
    }
}