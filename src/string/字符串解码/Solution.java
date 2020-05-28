/*
字符串解码
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
###解题思路
利用堆栈，将字符串拆分压入，遇到数字即组成一个完整数字压入，如‘2’+‘3' = "23"，遇到'['与普通字母直接压入
遇到']'则取栈中字符串，直到遇到第一个'['，组合成一个字符串后，取'['前面的数字，即为重复的次数，合成后压入堆栈，重复该步骤，最后遍历完字符串之后
堆栈中即为所求结果。
执行用时 :7 ms, 在所有 Java 提交中击败了16.25%的用户
内存消耗 :38.6 MB, 在所有 Java 提交中击败了7.69%的用户
 */
package string.字符串解码;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                String num = String.valueOf(s.charAt(i));
                while (i < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    num += s.charAt(i + 1);
                    i++;
                }
                stack.add(num);
                continue;
            }
            if (s.charAt(i) == ']') {
                String temp = "";
                String sumTemp = "";
                while (!stack.isEmpty() && !"[".equals(stack.peek())) {
                    temp = stack.pop() + temp;
                }
                stack.pop();
                String number = stack.pop();
                Integer count = Integer.valueOf(number);
                while (count > 0) {
                    sumTemp += temp;
                    count--;
                }
                stack.add(sumTemp);
                continue;
            }
            stack.add(String.valueOf(s.charAt(i)));
        }
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
}