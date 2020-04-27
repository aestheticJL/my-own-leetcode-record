/*
 搜索旋转排序数组
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
###解题思路
二分查找，先捋清楚每一步目标值落在哪个区间，逐步判断即可
执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗 :39.5 MB, 在所有 Java 提交中击败了17.74%的用户
 */
package array.搜索旋转排序数组;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length==0) return -1;
        return find(nums, 0, nums.length - 1, target);
    }

    public int find(int[] nums, int left, int right, int target) {
        if (left == right) return nums[left] == target ? left : -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > nums[left]) {
            if (target < nums[mid] && target >= nums[left]) return find(nums, left, mid, target);
            else return find(nums, mid + 1, right, target);
        } else {
            if (target > nums[mid] && target <= nums[right]) return find(nums, mid + 1, right, target);
            else return find(nums, left, mid, target);
        }
    }
}