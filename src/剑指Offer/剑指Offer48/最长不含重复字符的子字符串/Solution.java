/*
剑指 Offer 48. 最长不含重复字符的子字符串
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。



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


提示：

s.length <= 40000
###解题思路
双指针
执行用时：6 ms, 在所有 Java 提交中击败了90.24%的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer48.最长不含重复字符的子字符串;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Character> set = new HashSet();
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (!set.add(s.charAt(right))) {
                while (true) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left++;
                        break;
                    } else {
                        set.remove(s.charAt(left));
                        left++;
                    }
                }
            }
            res = res > right - left + 1 ? res : right - left + 1;
            right++;
        }
        return res;
    }
}