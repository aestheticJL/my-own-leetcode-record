/*
最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
###解题思路
遍历字符串，分以一个或两个字母两种情况从中间向两边扩展
 */
package string.最长回文子串;

class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            String tempOne = s.charAt(i) + "";
            while (left < right && left > -1 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    tempOne = s.charAt(left) + tempOne + s.charAt(right);
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            left = i;
            right = i + 1;
            String tempTwo = "";
            if (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                tempTwo = s.charAt(left) + "" + s.charAt(right);
                left--;
                right++;
                while (left < right && left > -1 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        tempTwo = s.charAt(left) + tempTwo + s.charAt(right);
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
            }
            res = res.length() > tempOne.length() ? res : tempOne;
            res = res.length() > tempTwo.length() ? res : tempTwo;
        }
        return res;
    }
}