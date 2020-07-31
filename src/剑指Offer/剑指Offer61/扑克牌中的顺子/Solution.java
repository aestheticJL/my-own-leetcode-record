/*
剑指 Offer 61. 扑克牌中的顺子
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。



示例 1:

输入: [1,2,3,4,5]
输出: True


示例 2:

输入: [0,0,1,2,5]
输出: True


限制：

数组长度为 5

数组的数取值为 [0, 13] .
###解题思路
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37.3 MB, 在所有 Java 提交中击败了58.61%的用户
 */
package 剑指Offer.剑指Offer61.扑克牌中的顺子;

class Solution {
    public boolean isStraight(int[] nums) {
        int[] helper = new int[14];
        for (int num : nums) {
            helper[num]++;
        }
        int flag = 0;
        for (int i = 1; i < 14; i++) {
            if (helper[i] > 1) return false;
            if (flag > 0 && helper[i] == 0) {
                if (helper[0] < 1) return false;
                else {
                    helper[0]--;
                    flag++;
                }
            }
            if (helper[i] == 1) flag++;
            if (flag+helper[0] >= 5) return true;
        }
        return false;
    }
}