/*
207. 课程表
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？



示例 1:

输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。


提示：

输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
1 <= numCourses <= 10^5
###解题思路
dfs
执行用时：4 ms, 在所有 Java 提交中击败了93.04%的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了98.02%的用户
 */
package dfs.课程表;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> list;
    boolean flag;
    int[] vis;
    int[] isOK;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        list = new ArrayList();
        flag = false;
        vis = new int[numCourses];
        isOK = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList());
        }
        for (int[] arr : prerequisites) {
            list.get(arr[0]).add(arr[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            vis[i] = 1;
            dfs(list.get(i));
            vis[i] = 0;
            isOK[i] = 1;
            if (flag) return false;
        }
        return true;
    }

    public void dfs(List<Integer> condition) {
        for (int a : condition) {
            if (isOK[a] == 1) continue;
            if (vis[a] == 1) {
                flag = true;
                break;
            }
            vis[a] = 1;
            dfs(list.get(a));
            vis[a] = 0;
            isOK[a] = 1;
        }
    }
}