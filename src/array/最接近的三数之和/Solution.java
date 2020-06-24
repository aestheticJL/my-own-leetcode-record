/*
最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。



示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。


提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
###解题思路
参考三数之和
执行用时：25 ms, 在所有 Java 提交中击败了9.24%的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了6.82%的用户
 */
package array.最接近的三数之和;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int first = 0; first < nums.length; first++) {
            if (nums[first] > 0 && nums[first] - target > min) break;
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int temp = target - nums[first];
            int second = first + 1;
            int third = nums.length - 1;
            for (; second < third; second++) {
                if (nums[second] > 0 && nums[second] - temp > min) break;
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third) {
                    if (nums[first] + nums[second] + nums[third] == target) return target;
                    if (Math.abs(nums[second] + nums[third] - temp) < min) {
                        res = nums[first] + nums[second] + nums[third];
                        min = Math.abs(res - target);
                    }
                    third--;
                }
                third = nums.length - 1;
            }
        }
        return res;
    }
}