/*
剑指 Offer 45. 把数组排成最小的数
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。



示例 1:

输入: [10,2]
输出: "102"
示例 2:

输入: [3,30,34,5,9]
输出: "3033459"


提示:

0 < nums.length <= 100
###解题思路
执行用时：9 ms, 在所有 Java 提交中击败了33.47%的用户
内存消耗：39.3 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer45.把数组排成最小的数;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", list);
    }
}