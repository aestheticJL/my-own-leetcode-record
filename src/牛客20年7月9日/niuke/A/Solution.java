/*
链接：https://ac.nowcoder.com/acm/contest/6218/A
来源：牛客网

给定一个只包含小写字母的字符串s，牛牛想将这个字符串中的所有'a'字母全部移动到字符串的末尾，而且保证其它字符的相对顺序不变。其中字符串s的长度<=1e6。

示例1
输入
"abcavv"
输出
"bcvvaa"
 */
package 牛客20年7月9日.niuke.A;

public class Solution {
    /**
     * @param s string字符串
     * @return string字符串
     */
    public String change(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                sum++;
            }
        }
        String a = s.replace("a", "");
        StringBuilder stringBuilder = new StringBuilder(a);
        while (sum > 0) {
            stringBuilder.append('a');
            sum--;
        }
        return stringBuilder.toString();
    }
}