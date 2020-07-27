/*
剑指 Offer 39. 数组中出现次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。



你可以假设数组是非空的，并且给定的数组总是存在多数元素。



示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2


限制：

1 <= 数组长度 <= 50000
###解题思路
利用hashmap
执行用时：19 ms, 在所有 Java 提交中击败了16.91%的用户
内存消耗：44.9 MB, 在所有 Java 提交中击败了100.00%的用户

摩尔计数法，可以理解为不同数字之间两两抵消，数量大于总长度一半的数字一定会留到最后
执行用时：2 ms, 在所有 Java 提交中击败了74.43%的用户
内存消耗：43.2 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer39.数组中出现次数超过一半的数字;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        int count = nums.length / 2 + 1;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) >= count) return nums[i];
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}