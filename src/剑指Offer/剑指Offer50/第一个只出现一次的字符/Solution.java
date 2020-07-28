/*
剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = ""
返回 " "


限制：

0 <= s 的长度 <= 50000
###解题思路
两次搜索第一次记录个数，第二次遇到个数为1的直接返回
执行用时：7 ms, 在所有 Java 提交中击败了84.04%的用户
内存消耗：40.3 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer50.第一个只出现一次的字符;

class Solution {
    public char firstUniqChar(String s) {
        char[] res = new char[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (res[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }
        return ' ';
    }
}