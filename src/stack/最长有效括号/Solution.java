/*
32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
###解题思路
只要左括号数量不小于右括号数量，那么它就有机会合法，否则重新开始计算，一旦左括号数量等于右括号数量那么就是有效字串，一次遍历会漏掉如“（（）”这样的情况，
所以两次遍历，第二次从尾开始
执行用时：2 ms, 在所有 Java 提交中击败了80.16%的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了91.77%的用户
 */
package stack.最长有效括号;

class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            if (s.charAt(i) == ')') right++;
            if (left == right) res = Math.max(res, right);
            if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) == '(') left++;
            if (s.charAt(i) == ')') right++;
            if (left == right) res = Math.max(res, right);
            if (right < left) {
                left = right = 0;
            }
        }
        return res * 2;
    }
}