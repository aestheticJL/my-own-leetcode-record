/*
面试题56 - I. 数组中数字出现的次数
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。



示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]


限制：

2 <= nums <= 10000
###解题思路
做法太多了，但真正满足题意时间复杂度空间复杂度的只有异或做法：
x^x = 0
x^0 = x
将所有数和0进行异或运算最后得到的值是唯二两个只出现一次的数异或运算的值a^b
sum & (-sum)得到sum二进制中为1的最低位，两个数在该位上必然不同（因为sum是异或运算结果）
这个1即是a与b的二进制上的区别(之一)

第二种方法
二分法，如果左右两个数组异或都不为0，那么两个不重复数落在两边直接出结果，否则继续二分
 */
package 剑指Offer.剑指Offer56.数组中数字出现的次数;

class Solution {
    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        //sum & (-sum)本身的作用是得到最低位的1
        int flag = (-sum) & sum;
        //分组，flag是sum二进制中为1的最低位，两个数在该位上必然不同（因为sum是异或运算结果）
        for (int num : nums) {
            if ((flag & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
    public int[] singleNumbers2(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, zeroCount = 0;
        for (int num: nums) {
            if (num == 0) {
                zeroCount += 1;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum ^= num;
        }
        // 需要特判一下某个数是0的情况。
        if (zeroCount == 1) {
            return new int[]{sum, 0};
        }
        int lo = min, hi = max;
        while (lo <= hi) {
            // 根据 lo 的正负性来判断二分位置怎么写，防止越界。
            int mid = (lo < 0 && hi > 0)? (lo + hi) >> 1: lo + (hi - lo) / 2;
            int loSum = 0, hiSum = 0;
            for (int num: nums) {
                if (num <= mid) {
                    loSum ^= num;
                } else {
                    hiSum ^= num;
                }
            }
            if (loSum != 0 && hiSum != 0) {
                // 两个都不为0，说明 p 和 q 分别落到2个数组里了。
                return new int[] {loSum, hiSum};
            }
            if (loSum == 0) {
                // 说明 p 和 q 都比 mid 大，所以比 mid 小的数的异或和变为0了。
                lo = mid + 1;
            } else {
                // 说明 p 和 q 都不超过 mid
                hi = mid - 1;
            }
        }
        // 其实如果输入是符合要求的，程序不会执行到这里，为了防止compile error加一下
        return null;
    }
}