/*
跳水板
你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。

返回的长度需要从小到大排列。

示例：

输入：
shorter = 1
longer = 2
k = 3
输出： {3,4,5,6}
提示：

0 < shorter <= longer
0 <= k <= 100000
###解题思路
。。。小学数学，注意longer==shorter和k=0
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：47.7 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package array.跳水板;

class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{k};
        int min = shorter * k;
        int max = longer * k;
        int temp = longer - shorter;
        int count = (max - min) / temp + 1;
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = min + i * temp;
        }
        return res;
    }
}