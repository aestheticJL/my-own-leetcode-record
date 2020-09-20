/*
78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
###解题思路
dfs
 */
package dfs.子集;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    List<Integer> list;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums.length == 0) return res;
        list = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}