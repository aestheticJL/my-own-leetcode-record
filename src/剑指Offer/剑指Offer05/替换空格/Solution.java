/*
剑指 Offer 05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。



示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."


限制：

0 <= s 的长度 <= 10000
###解题思路
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer05.替换空格;

class Solution {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') stringBuilder.append("%20");
            else stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
//    public String replaceSpace(String s) {
//        return s.replace(" ","%20");
//    }
}