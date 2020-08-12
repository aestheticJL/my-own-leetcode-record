/*
面试题 16.26. 计算器
给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。

表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。
###解题思路
使用栈模拟
执行用时：15 ms, 在所有 Java 提交中击败了73.52%的用户
内存消耗：43 MB, 在所有 Java 提交中击败了17.31%的用户
 */
package stack.计算器;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int calculate(String s) {
        int index = 0;
        int num = 0;
        char opt = '+';
        Deque<Integer> stack = new LinkedList<>();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            if ((!Character.isDigit(c) && c != ' ') || index == s.length() - 1) {
                if (opt == '+')
                    stack.push(num);
                else if (opt == '-')
                    stack.push(-num);
                else if (opt == '*')
                    stack.push(stack.pop() * num);
                else if (opt == '/')
                    stack.push(stack.pop() / num);
                num = 0;
                opt = c;
            }
            index++;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}