/*
剑指 Offer 57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。



示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]


限制：

1 <= target <= 10^5
###解题思路
双指针
执行用时：2 ms, 在所有 Java 提交中击败了93.55%的用户
内存消耗：37.8 MB, 在所有 Java 提交中击败了12.99%的用户
 */
package 剑指Offer.剑指Offer57.和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < target) {
            if (sum == target) {
                int[] newInt = new int[right - left + 1];
                int temp = left;
                for (int i = 0; i < newInt.length; i++) {
                    newInt[i] = temp++;
                }
                res.add(newInt);
                right++;
                sum += right;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        int[][] arr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}