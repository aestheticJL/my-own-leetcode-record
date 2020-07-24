/*
剑指 Offer 11. 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0
###解题思路
直接遍历也可，为O(n)
使用二分为O(log n)
需要注意的是，有一种特殊情况，根本没旋转的情况，如果我们二分比较的是mid和left而不是mid和right，那么最后指针会在numbers.length - 1碰撞，反之会在0处碰撞
显然我们需要的结果是0，所以比较的时候应该是比较mid和right
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer11.旋转数组的最小数字;

class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}