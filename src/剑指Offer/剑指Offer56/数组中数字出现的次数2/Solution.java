/*
剑指 Offer 56 - II. 数组中数字出现的次数 II
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。



示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1


限制：

1 <= nums.length <= 10000
1 <= nums[i] < 2^31
###解题思路
hash表
执行用时：15 ms, 在所有 Java 提交中击败了47.15%的用户
内存消耗：41.2 MB, 在所有 Java 提交中击败了9.52%的用户

位运算法
计算所有位的和，对于无法整除3的位，就是目标数为1的位
执行用时：8 ms, 在所有 Java 提交中击败了62.20%的用户
内存消耗：40.6 MB, 在所有 Java 提交中击败了69.05%的用户
 */
package 剑指Offer.剑指Offer56.数组中数字出现的次数2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1) return num;
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        int[] bit = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bit[j] = nums[i] & 1;
                nums[i] = nums[i] >> 1;
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] % 3 != 0 ? Math.pow(2, i) : 0;
        }
        return res;
    }
}