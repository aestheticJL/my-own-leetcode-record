/*
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

### 解题思路

    dfs+剪枝，在任意阶段的字符串中：")"的数量绝对不能大于"("

###

执行用时 :2 ms, 在所有 Java 提交中击败了55.37%的用户
内存消耗 :39.5 MB, 在所有 Java 提交中击败了5.01%的用户

*/


package string.括号生成;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return null;
        }
        List<String> results = new ArrayList<>();
        dfs(0, 0, "", n,results);
        return results;
    }

    public static void dfs(int open, int end, String s, int n,List<String> results) {
        if (open == n && end == n) {
            results.add(s);
            return;
        }
        if (open < n) {
            s += "(";
            dfs(open + 1, end, s, n,results);
            s = s.substring(0, s.length() - 1);
        }
        if (end < n && end < open) {
            s += ")";
            dfs(open, end + 1, s, n,results);
        }
    }
}