/*
剑指 Offer 53 - I. 在排序数组中查找数字 I
统计一个数字在排序数组中出现的次数。



示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0


限制：

0 <= 数组长度 <= 50000
###解题思路
二分
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：42.9 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer53.在排序数组中查找数字1;

class Solution {
    public int search(int[] nums, int target) {
        int res = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        while (left < nums.length && nums[left] <= target) {
            if (nums[left] == target) res++;
            left++;
        }
        return res;
    }
}