/*
1248. 统计「优美子数组」
给你一个整数数组 nums 和一个整数 k。

如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中「优美子数组」的数目。



示例 1：

输入：nums = [1,1,2,1,1], k = 3
输出：2
解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
示例 2：

输入：nums = [2,4,6], k = 1
输出：0
解释：数列中不包含任何奇数，所以不存在优美子数组。
示例 3：

输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
输出：16


提示：

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
### 解题思路
这题写成了暴搜(很垃圾就是了)
滑动窗口的思路
其实得到所有奇数下标可以通过数学的方法计算，不需要遍历左右所有可能
执行用时 :1282 ms, 在所有 Java 提交中击败了5.17%的用户
内存消耗 :48.7 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package array.优美子数组;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int sum = 0;
        int temp = 0;
        int odd[] = new int[k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                temp++;
                odd[temp] = i;
            }
            if (temp == k) {
                sum++;
                int left = odd[1];
                int right = odd[k];
                int tempLeft = left;
                int tempRight;
                while (tempLeft > 0 && nums[tempLeft - 1] % 2 == 0) {
                    tempLeft--;
                    sum++;
                    tempRight = right;
                    while (tempRight < nums.length - 1 && nums[tempRight + 1] % 2 == 0) {
                        tempRight++;
                        sum++;
                    }
                }
                tempRight = right;
                while (tempRight < nums.length - 1 && nums[tempRight + 1] % 2 == 0) {
                    tempRight++;
                    sum++;
                }
                temp--;
                for (int o = 1; o < odd.length; o++) {
                    if (o == odd.length - 1) {
                        odd[o] = 0;
                        continue;
                    }
                    odd[o] = odd[o + 1];
                }
            }
        }
        return sum;
    }
}