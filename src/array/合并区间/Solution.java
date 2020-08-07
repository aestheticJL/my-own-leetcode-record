/*
 合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
###解题思路
先排序然后合并
 */
package array.合并区间;

import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0) return new int[0][];
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        int[][] res = new int[intervals.length][2];
        res[0] = new int[]{intervals[0][0],intervals[0][1]};
        int index = 0;
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0]>intervals[index][1]){
                index++;
                res[index][0] = intervals[i][0];
                res[index][1] = intervals[i][1];
            }else{
                res[index][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(res,index+1);
    }
}