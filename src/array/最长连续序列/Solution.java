/*
128. 最长连续序列
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
package array.最长连续序列;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Integer[] newNums = new Integer[set.size()];
        set.toArray(newNums);
        int res = 0;
        for (int num : newNums) {
            if (map.containsKey(num-1)) {
                map.put(num, map.get(num - 1) + 1);
            } else {
                map.put(num, 1);
            }
            res = res > map.get(num) ? res : map.get(num);
            while (map.containsKey(num+1)) {
                map.put(num + 1, (map.get(num + 1) > map.get(num) ? map.get(num + 1) : map.get(num)) + 1);
                num++;
            }
            res = res > map.get(num) ? res : map.get(num);
        }
        return res;
    }
}