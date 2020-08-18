/*
456. 132模式
给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。

注意：n 的值小于15000。

示例1:

输入: [1, 2, 3, 4]

输出: False

解释: 序列中不存在132模式的子序列。
示例 2:

输入: [3, 1, 4, 2]

输出: True

解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
示例 3:

输入: [-1, 3, 2, 0]

输出: True

解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
###解题思路
用单调栈，栈中存放的是3，min中存放的是2，可以保证2一定比3小，找出比2小的1即可
执行用时：10 ms, 在所有 Java 提交中击败了56.03%的用户
内存消耗：40.5 MB, 在所有 Java 提交中击败了36.97%的用户
 */
package stack.字节132模式;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        Deque<Integer> stack = new LinkedList();
        int min = Integer.MIN_VALUE;
        int index = nums.length - 1;
        while (index >= 0) {
            if (nums[index] < min) return true;
            while (!stack.isEmpty() && (stack.peek() < nums[index])) {
                min = stack.pop();
            }
            stack.push(nums[index]);
            index--;
        }
        return false;
    }
}