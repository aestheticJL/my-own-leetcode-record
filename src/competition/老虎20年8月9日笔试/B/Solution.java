package competition.老虎20年8月9日笔试.B;

import java.util.*;


public class Solution {
    /**
     * int，返回做完x个任务后能达到的最高等级
     *
     * @param x     int整型 需要完成的任务数量
     * @param level int整型 初始等级
     * @param tasks int整型二维数组 表示可供选择的任务，tasks[i][0]表示第i个任务所需的最低等级，task[i][1]表示第i个任务完成后能提升的等级
     * @return int整型
     */
    public int maxLevel(int x, int level, int[][] tasks) {
        int res = level;
        Arrays.sort(tasks, (o1, o2) -> o1[0] - o2[0]);
        while (x > 0) {
            int index = helper(tasks, res);
            if (index == -1) break;
            res += tasks[index][1];
            tasks[index][1] = -1;
            x--;
        }
        return res;
    }

    public int helper(int[][] tasks, int level) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i][0] > level) break;
            if (tasks[i][1] > max) {
                max = tasks[i][1];
                index = i;
            }
        }
        return index;
    }
}