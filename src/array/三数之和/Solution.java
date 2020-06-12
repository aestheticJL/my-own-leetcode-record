/*
 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
###解题思路
把题目转换为求a+b=-c，思路同等于两数之和，值得注意的是题目要求结果不重复，可以先排序然后进行遍历，遇到和上一个数一样的即跳过
执行用时 :22 ms, 在所有 Java 提交中击败了94.05%的用户
内存消耗 :44.1 MB, 在所有 Java 提交中击败了97.48%的用户
 */
package array.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (nums[first] > 0) break;//第一个数大于0，后面的数也都大于0，直接结束
            if (first > 0 && nums[first] == nums[first - 1]) continue;//第一个数和上一次相同
            int sum = -nums[first];//题目转化为两数之和
            int second = first + 1;
            int third = nums.length - 1;
            for (; second < third; second++) {
                if (nums[second] > sum) break;//第二个数大于sum，和第三个数的和也必然大于sum，结束
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;//第二个数和上一个数相同
                while (second < third && nums[second] + nums[third] > sum) {//指针左移
                    third--;
                }
                if (second == third) break;
                if (nums[second] + nums[third] == sum) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}