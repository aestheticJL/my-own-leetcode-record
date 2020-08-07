/*
34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
###解题思路
二分再二分
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：43 MB, 在所有 Java 提交中击败了47.30%的用户
 */
package array.在排序数组中查找元素的第一个和最后一个位置;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) return res;
        int first = helper(nums, target, 0, nums.length - 1);
        if (nums[first] != target) return res;
        res[0] = helperLeft(nums, target, 0, first);
        res[1] = helperRight(nums, target, first, nums.length - 1);
        return res;
    }

    public int helper(int[] nums, int target, int begin, int end) {
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target) {
                begin = mid;
                break;
            }
            if (nums[mid] > target) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

    public int helperLeft(int[] nums, int target, int begin, int end) {
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] != target) begin = mid + 1;
            else {
                if (mid == begin || mid == end || nums[mid - 1] != target) {
                    return mid;
                } else {
                    end = mid;
                }
            }
        }
        return end;
    }

    public int helperRight(int[] nums, int target, int begin, int end) {
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] != target) end = mid;
            else {
                if (mid == begin || mid == end || nums[mid + 1] != target) {
                    return mid;
                } else {
                    begin = mid + 1;
                }
            }
        }
        return begin;
    }
}