package array.盛水最多的容器;
/*
11. 盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

###解题思路
双指针对撞，装水数量取决于短边和底的长度，由于每次移动都会减少底，所以应当增长短边，故短边指针移动。
执行用时 :3 ms, 在所有 Java 提交中击败了92.82%的用户
内存消耗 :39.9 MB, 在所有 Java 提交中击败了37.86%
的用户
 */
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = max > Math.min(height[left], height[right]) * (right - left) ? max
                    : Math.min(height[left], height[right]) * (right - left);
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return max;
    }
}