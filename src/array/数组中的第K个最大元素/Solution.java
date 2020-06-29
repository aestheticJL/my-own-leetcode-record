/*
数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
###解题思路
适当剪枝，优化快速排序
执行用时：2 ms, 在所有 Java 提交中击败了92.63%的用户
内存消耗：40.2 MB, 在所有 Java 提交中击败了6.12%的用户
 */
package array.数组中的第K个最大元素;

import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }

    public void quickSort(int nums[], int left, int right, int topK) {
        if (left >= right) return;
        Random random = new Random();
        int ran = left + random.nextInt(right - left);
        int key = nums[ran];
        nums[ran] = nums[left];
        nums[left] = key;
        int low = left;
        int high = right;
        while (high > low) {
            while (nums[high] >= key && high > low) {
                high--;
            }
            nums[low] = nums[high];
            while (nums[low] <= key && high > low) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = key;
        if (low == topK) return;
        if (low > topK) {
            quickSort(nums, left, low - 1, topK);
        } else {
            quickSort(nums, low + 1, right, topK);
        }
    }
}