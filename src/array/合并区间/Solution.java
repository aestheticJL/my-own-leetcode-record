package array.合并区间;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));
        int[][] result = new int[intervals.length][2];
        int temp = -1;
        for (int[] interval : intervals) {
            if (temp == -1 || interval[0] > result[temp][1]) {
                result[++temp] = interval;
            } else {
                result[temp][1] = Math.max(result[temp][1], interval[1]);
            }
        }
        return Arrays.copyOf(result, temp + 1);
    }
}