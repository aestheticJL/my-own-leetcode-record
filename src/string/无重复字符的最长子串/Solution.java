/*
无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
###解题思路
双指针，滑动窗口
执行用时 :6 ms, 在所有 Java 提交中击败了85.22%的用户
内存消耗 :40.4 MB, 在所有 Java 提交中击败了5.20%的用户
 */
package string.无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                result = result > set.size() ? result : set.size();
            } else {
                for (int j = left; j <= i; j++) {
                    if (s.charAt(j) == s.charAt(i)){
                        left = j + 1;
                        break;
                    }else {
                        set.remove(s.charAt(j));
                    }
                }
            }
        }
        return result;
    }
}