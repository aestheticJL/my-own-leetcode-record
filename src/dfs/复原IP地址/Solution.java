/*
93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。



示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "1111"
输出：["1.1.1.1"]
示例 4：

输入：s = "010010"
输出：["0.10.0.10","0.100.1.0"]
示例 5：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


提示：

0 <= s.length <= 3000
s 仅由数字组成
###解题思路
dfs
执行用时：3 ms, 在所有 Java 提交中击败了68.80%的用户
内存消耗：39.5 MB, 在所有 Java 提交中击败了64.87%的用户
 */
package dfs.复原IP地址;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> list;
    List<Integer> ip;

    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();
        ip = new ArrayList<>();
        dfs(s, 0);
        return list;
    }

    public void dfs(String s, int index) {
        if (index == s.length() && ip.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : ip) {
                sb.append(integer + ".");
            }
            sb.deleteCharAt(sb.length() - 1);
            list.add(sb.toString());
        }
        if (index == s.length() || ip.size() == 4) return;
        if (s.charAt(index) == '0') {
            ip.add(0);
            dfs(s, index + 1);
            ip.remove(ip.size() - 1);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i <= s.length()) {
                String temp = s.substring(index, index + i);
                Integer next = Integer.valueOf(temp);
                if (next <= 255) {
                    ip.add(next);
                    dfs(s, index + i);
                    ip.remove(ip.size() - 1);
                }
            }
        }
    }
}