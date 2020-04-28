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
sum & (-sum)得到最低位的1
这个1即是a与b的二进制上的区别(之一)

 */
package array.数组中数字出现的次数;

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
}