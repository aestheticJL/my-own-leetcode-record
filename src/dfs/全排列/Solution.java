/*
46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
### 解题思路

基础的dfs

执行用时 :2 ms, 在所有 Java 提交中击败了77.90%的用户
内存消耗 :39.9 MB, 在所有 Java 提交中击败了5.13%的用户

 */
package dfs.全排列;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfs(nums, results, result, visited);
        return results;
    }

    public static void dfs(int[] nums, List<List<Integer>> results, List<Integer> result, int[] visited) {
        if (result.size() == nums.length) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            result.add(nums[i]);
            visited[i] = 1;
            dfs(nums, results, result, visited);
            visited[i] = 0;
            result.remove(result.size() - 1);
        }
    }
}
