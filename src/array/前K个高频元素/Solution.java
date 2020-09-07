/*
347. 前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。



示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]


提示：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
###解题思路
小顶堆（优先队列实现）
执行用时：16 ms, 在所有 Java 提交中击败了79.68%的用户
内存消耗：42.3 MB, 在所有 Java 提交中击败了55.40%的用户
 */
package array.前K个高频元素;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            Integer orDefault = map.getOrDefault(num, 0);
            map.put(num, orDefault + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek()[1] < entry.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            } else {
                priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }
}