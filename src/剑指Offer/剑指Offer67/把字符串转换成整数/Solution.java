/*
剑指 Offer 67. 把字符串转换成整数
写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。



首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。
###解题思路
逐步判断即可
执行用时：2 ms, 在所有 Java 提交中击败了99.95%的用户
内存消耗：39.5 MB, 在所有 Java 提交中击败了86.57%的用户
 */
package 剑指Offer.剑指Offer67.把字符串转换成整数;

class Solution {
    public int strToInt(String str) {
        String s = str.trim();
        if (s.equals("")) return 0;
        char first = s.charAt(0);
        if (first != '-' && first != '+' && (first < '0' || first > '9')) return 0;
        long res = 0;
        boolean flag = false;
        if (first == '-' || first == '+') {
            int index = 1;
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                res *= 10;
                res += s.charAt(index) - '0';
                if (res > Integer.MAX_VALUE) {
                    if (first == '-') return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
                index++;
            }
            if (first == '-') res = -res;
        } else {
            int index = 0;
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                res *= 10;
                res += s.charAt(index) - '0';
                if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                index++;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strToInt("-2147483649"));
    }
}