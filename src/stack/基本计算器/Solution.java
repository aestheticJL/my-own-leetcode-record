/*
224. 基本计算器
实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。

示例 1:

输入: "1 + 1"
输出: 2
示例 2:

输入: " 2-1 + 2 "
输出: 3
示例 3:

输入: "(1+(4+5+2)-3)+(6+8)"
输出: 23
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。
###解题思路
利用栈来完成这一操作
执行用时：39 ms, 在所有 Java 提交中击败了28.74%的用户
内存消耗：45.8 MB, 在所有 Java 提交中击败了18.25%的用户
 */
package stack.基本计算器;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    Deque<String> stack = new LinkedList();

    public int calculate(String s) {
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                index++;
                continue;
            }
            if (s.charAt(index) == '+' || s.charAt(index) == '-' || s.charAt(index) == '(') {
                stack.push(s.charAt(index) + "");
                index++;
                continue;
            }
            if (s.charAt(index) == ')') {
                String meger = meger();
                stack.push(meger);
                index++;
                continue;
            }
            if (s.charAt(index) == '*') {
                String pop = stack.pop();
                index++;
                StringBuilder sb = new StringBuilder();
                while (index < s.length() && (s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
                    sb.append(s.charAt(index));
                    index++;
                }
                int i = Integer.valueOf(sb.toString()) * Integer.valueOf(pop);
                stack.push(i + "");
                continue;
            }
            if (s.charAt(index) == '/') {
                String pop = stack.pop();
                index++;
                StringBuilder sb = new StringBuilder();
                while (index < s.length() && (s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
                    sb.append(s.charAt(index));
                    index++;
                }
                int i = Integer.valueOf(pop) / Integer.valueOf(sb.toString());
                stack.push(i + "");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (index < s.length() && (s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
                sb.append(s.charAt(index));
                index++;
            }
            stack.push(sb.toString());
        }
        return Integer.valueOf(meger());
    }

    public String meger() {
        Deque<String> tempStack = new LinkedList();
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (pop.equals("(")) break;
            tempStack.push(pop);
        }
        int res = Integer.valueOf(tempStack.pop());
        while (!tempStack.isEmpty()) {
            String pop = tempStack.pop();
            if (pop.equals("+")) res += Integer.valueOf(tempStack.pop());
            else if (pop.equals("-")) res -= Integer.valueOf(tempStack.pop());
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}