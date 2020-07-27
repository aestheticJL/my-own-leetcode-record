/*
剑指 Offer 38. 字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。



你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。



示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]


限制：

1 <= s 的长度 <= 8
###解题思路
全排列
执行用时：48 ms, 在所有 Java 提交中击败了25.14%的用户
内存消耗：44.4 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer38.字符串的排列;

import java.util.HashSet;
import java.util.Set;

class Solution {
    StringBuilder sb = new StringBuilder();
    Set<String> set;
    int l;

    public String[] permutation(String s) {
        l = s.length();
        set = new HashSet<>();
        char[] arr = s.toCharArray();
        int[] visit = new int[arr.length];
        dfs(arr, visit);
        String[] res = new String[set.size()];
        int i = 0;
        for (String setValue : set) {
            res[i++] = setValue;
        }
        return res;
    }

    public void dfs(char[] arr, int[] visit) {
        if (sb.length() == l) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visit[i] == 0) {
                sb.append(arr[i]);
                visit[i] = 1;
                dfs(arr, visit);
                sb.deleteCharAt(sb.length() - 1);
                visit[i] = 0;
            }
        }
    }
}