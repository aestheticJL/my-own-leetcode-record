/*
链接：https://ac.nowcoder.com/acm/contest/6219/B
来源：牛客网

题目描述
今天牛牛去游乐园玩过山车项目，他觉得过山车在上坡下坡的过程是非常刺激的，回到家之后就受到启发，想到了一个问题。
如果把整个过山车的轨道当作是一个长度为n的数组num，那么在过山车上坡时数组中的值是呈现递增趋势的，到了最高点以后，数组中的值呈现递减的趋势，
牛牛把符合这样先增后减规律的数组定义为金字塔数组，请你帮牛牛在整个num数组中找出长度最长的金字塔数组，如果金字塔数组不存在，请输出0。
 */
package competition.牛客20年7月11日.B;

import java.util.*;


public class Solution {
    /**
     * @param n   int整型
     * @param num int整型一维数组
     * @return int整型
     */
    int res;

    public int getMaxLength(int n, int[] num) {
        res = 0;
        int begin = 0;
        helper(begin, num);
        return res;
    }

    public void helper(int begin, int[] num) {
        int temp = begin;
        for (int i = begin + 1; i < num.length; i++) {
            if (num[i] <= num[i - 1]) continue;
            begin = i;
            break;
        }
        if (begin == temp) return;
        int start = begin - 1;
        while (begin + 1 < num.length && num[begin + 1] > num[begin]) {
            begin++;
        }
        while (begin + 1 < num.length && num[begin + 1] < num[begin]) {
            begin++;
        }
        res = Math.max(res, begin - start + 1);
        if (num.length - begin < res) return;
        else helper(begin, num);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMaxLength(1, new int[]{3,1,2,4,5,6,1,4,2}));
    }
}