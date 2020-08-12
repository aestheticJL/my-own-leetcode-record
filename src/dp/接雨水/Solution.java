/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
###接雨水
对于每一个元素，它能接的水就是左边最高的柱子和右边最高的柱子中较矮的那一根和自己的差值。
执行用时：1 ms, 在所有 Java 提交中击败了99.98%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了45.99%的用户
 */
package dp.接雨水;

class Solution {
    public int trap(int[] height) {
        int leftArr[] = new int[height.length];
        int left = 0;
        int rightArr[] = new int[height.length];
        int right = 0;
        for (int i = 0; i < height.length; i++) {
            leftArr[i] = left;
            if (height[i] > left) {
                left = height[i];
            }
            int i2 = height.length - 1 - i;
            rightArr[i2] = right;
            if (height[i2] > right) {
                right = height[i2];
            }
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (Math.min(leftArr[i], rightArr[i]) > height[i]) res += Math.min(leftArr[i], rightArr[i]) - height[i];
        }
        return res;
    }
}