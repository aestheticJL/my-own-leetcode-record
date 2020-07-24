/*
剑指 Offer 03. 数组中重复的数字
找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3


限制：

2 <= n <= 100000
###解题思路
不多说
执行用时：5 ms, 在所有 Java 提交中击败了51.55%的用户
内存消耗：49.7 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer03.数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return nums[i];
        }
        return 0;
    }
}