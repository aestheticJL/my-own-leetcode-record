/*
剑指 Offer 57. 和为s的两个数字
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。



示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
示例 2：

输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]


限制：

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6
###解题思路
hash表
执行用时：63 ms, 在所有 Java 提交中击败了8.29%的用户
内存消耗：59.6 MB, 在所有 Java 提交中击败了6.39%的用户

二分
执行用时：43 ms, 在所有 Java 提交中击败了22.04%的用户
内存消耗：57.1 MB, 在所有 Java 提交中击败了36.17%的用户

双指针
执行用时：2 ms, 在所有 Java 提交中击败了98.20%的用户
内存消耗：57 MB, 在所有 Java 提交中击败了41.85%的用户
 */
package 剑指Offer.剑指Offer57.和为s的两个数字;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{nums[i], target - nums[i]};
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int left = i;
            int right = nums.length - 1;
            int key = target - nums[i];
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == key) return new int[]{key, target - key};
                if (nums[mid] > key) right = mid - 1;
                if (nums[mid] < key) left = mid + 1;
            }
            if (nums[left] == key && left != i) return new int[]{key, target - key};
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]==target) return new int[]{nums[left],nums[right]};
            if(nums[left]+nums[right]>target) right--;
            else left++;
        }
        return null;
    }
}