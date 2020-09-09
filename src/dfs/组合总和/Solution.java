/*
组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
###解题思路
dfs
执行用时：3 ms, 在所有 Java 提交中击败了87.50%的用户
内存消耗：39.8 MB, 在所有 Java 提交中击败了91.90%的用户
 */
package dfs.组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(target,0,candidates,0,new ArrayList());
        return res;
    }
    public void dfs(int target,int sum,int[] candidates,int index,List<Integer> list){
        if(sum == target){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = index;i<candidates.length;i++){
            if(sum+candidates[i]>target) return;
            else{
                list.add(candidates[i]);
                dfs(target,sum+candidates[i],candidates,i,list);
                list.remove(list.size()-1);
            }
        }
    }
}