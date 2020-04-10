/*

给定一个字符串，逐个翻转字符串中的每个单词。

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 

说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

### 解题思路

    不加api调用限制的话是非常基础的题目，翻转字符串再翻转单词或者拆分成数组再翻转输出都可以。
    执行用时 :30 ms, 在所有 Java 提交中击败了6.13%的用户
    内存消耗 :40.6 MB, 在所有 Java 提交中击败了5.41%的用户
###
 */
package string.翻转字符串里的单词;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        boolean flag = false;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 && s.charAt(i) != ' ') {
                temp += s.charAt(i);
                list.add(temp);
                break;
            }
            if (s.charAt(i) == ' ' && flag) {
                list.add(temp);
                temp = "";
                flag = false;
            } else if (s.charAt(i) != ' ') {
                temp += s.charAt(i);
                flag = true;
            }
        }
        Collections.reverse(list);
        String result = String.join(" ", list);
        return result;
    }
}