/*
二进制求和
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。



示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"


提示：

每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。
###解题思路
应当模拟计算，转数字容易溢出
将ab之间的短者补0，一样长度计算则十分方便
执行用时：3 ms, 在所有 Java 提交中击败了55.55%的用户
内存消耗：38.1 MB, 在所有 Java 提交中击败了7.69%的用户
 */
package string.二进制求和;

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int al = a.length();
        int bl = b.length();
        int n = Math.max(al, bl);
        int flag = 0;
        for (int i = 0; i < n; i++) {
            int aTemp = al > i ? Integer.valueOf(a.charAt(al - 1 - i) - '0') : 0;
            int bTemp = bl > i ? Integer.valueOf(b.charAt(bl - 1 - i) - '0') : 0;
            int sum = aTemp + bTemp + flag;
            if (sum / 2 == 1) flag = 1;
            else flag = 0;
            stringBuilder.append(sum % 2);
        }
        if (flag == 1) stringBuilder.append(1);
        return stringBuilder.reverse().toString();
    }
}