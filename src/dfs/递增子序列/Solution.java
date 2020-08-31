/*
491. 递增子序列
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
说明:

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
###解题思路
这是一个递归枚举子序列的通用模板，即用一个临时数组 \rm temptemp 来保存当前选出的子序列，使用 \rm curcur 来表示当前位置的下标，在 dfs(cur, nums) 开始之前，[0, {\rm cur} - 1][0,cur−1] 这个区间内的所有元素都已经被考虑过，而 [{\rm cur}, n][cur,n] 这个区间内的元素还未被考虑。在执行 dfs(cur, nums) 时，我们考虑 {\rm cur}cur 这个位置选或者不选，如果选择当前元素，那么把当前元素加入到 \rm temptemp 中，然后递归下一个位置，在递归结束后，应当把 \rm temptemp 的最后一个元素删除进行回溯；如果不选当前的元素，直接递归下一个位置。

当然，如果我们简单地这样枚举，对于每一个子序列，我们还需要做一次 O(n)O(n) 的合法性检查和哈希判重复，在执行整个程序的过程中，我们还需要使用一个空间代价 O(2^n)O(2
n
 ) 的哈希表来维护已经出现的子序列的哈希值。我们可以对选择和不选择做一些简单的限定，就可以让枚举出来的都是合法的并且不重复：

使序列合法的办法非常简单，即给「选择」做一个限定条件，只有当前的元素大于等于上一个选择的元素的时候才能选择这个元素，这样枚举出来的所有元素都是合法的

那如何保证没有重复呢？我们需要给「不选择」做一个限定条件，只有当当前的元素不等于上一个选择的元素的时候，才考虑不选择当前元素，直接递归后面的元素。因为如果有两个相同的元素，我们会考虑这样四种情况：

前者被选择，后者被选择
前者被选择，后者不被选择
前者不被选择，后者被选择
前者不被选择，后者不被选择
其中第二种情况和第三种情况其实是等价的，我们这样限制之后，舍弃了第二种，保留了第三种，于是达到了去重的目的。
 */
package dfs.递增子序列;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    List<Integer> list;

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList();
        list = new ArrayList();
        dfs(nums, 0, Integer.MIN_VALUE);
        return this.res;
    }

    public void dfs(int[] nums, int index, int last) {
        if (index == nums.length) {
            if (list.size() >= 2) {
                res.add(new ArrayList(list));
            }
            return;
        }
        if (index < nums.length) {
            if (nums[index] >= last) {
                list.add(nums[index]);
                dfs(nums, index + 1, nums[index]);
                list.remove(list.size() - 1);
            }
        }
        if (nums[index] != last) dfs(nums, index + 1, last);
    }
}