/*
剑指 Offer 17. 打印从1到最大的n位数
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]


说明：

用返回一个整数列表来代替打印
n 为正整数
###解题思路
dfs全排列
执行用时：10 ms, 在所有 Java 提交中击败了6.92%的用户
内存消耗：47.5 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer17.打印从1到最大的n位数;

class Solution {
    char[] num = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    int[] res;
    int index;

    public int[] printNumbers(int n) {
        int count = (int) Math.pow(10, n)-1;
        res = new int[count];
        index = 0;
        int k = 1;
        while (k <= n) {
            StringBuilder stringBuilder = new StringBuilder();
            dfs(k, stringBuilder);
            k++;
        }
        return res;
    }

    public void dfs(int k, StringBuilder stringBuilder) {
        if (stringBuilder.length() == k) {
            res[index] = Integer.valueOf(stringBuilder.toString());
            index++;
            return;
        }
        for (int j = 0; j < num.length; j++) {
            if (stringBuilder.length() == 0 && j == 0) continue;
            stringBuilder.append(num[j]);
            dfs(k, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}