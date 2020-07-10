/*
链接：https://ac.nowcoder.com/acm/contest/6218/B
来源：牛客网

一天，牛妹找牛牛做一个游戏，牛妹给牛牛写了一个数字n，然后又给自己写了一个数字m，她希望牛牛能执行最少的操作将他的数字转化成自己的。
操作共有三种，如下：
        1.在当前数字的基础上加一，如：4转化为5
        2.在当前数字的基础上减一，如：4转化为3
        3.将当前数字变成它的平方，如：4转化为16
        你能帮牛牛解决这个问题吗?

输入：
给定n,m,分别表示牛牛和牛妹的数字。

输出：
返回最少需要的操作数。
 */
package competition.牛客20年7月9日.B;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class map {
        int res;
        int number;

        public map(int res, int number) {
            this.res = res;
            this.number = number;
        }

        public int getRes() {
            return res;
        }

        public void setRes(int res) {
            this.res = res;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

    public int solve(int n, int m) {
        if (n >= m) {
            return n - m;
        }
        int sum = 1;
        Queue<map> queue = new LinkedList<>();
        if (m == n + 1 || m == n * n) return sum;
        queue.offer(new map(sum, n + 1));
        queue.offer(new map(sum, n - 1));
        queue.offer(new map(sum, n * n));
        while (!queue.isEmpty()) {
            map poll = queue.poll();
            int number = poll.getNumber();
            int res = poll.getRes() + 1;
            if (m == number + 1 || m == number - 1 || m == number * number)
                return res;
            else {
                queue.offer(new map(res, number + 1));
                queue.offer(new map(res, number - 1));
                queue.offer(new map(res, number * number));
            }
        }
        return 0;
    }
}