/*
将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 ###解题思路
 二分
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：
39.9 MB, 在所有 Java 提交中击败了8.70%的用户
 */
package tree.将有序数组转换为二叉搜索树;

import tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return bisect(nums, left, right);
    }

    public TreeNode bisect(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + ((right - left)>> 1);
        TreeNode newTree = new TreeNode(nums[mid]);
        newTree.left = bisect(nums, left, mid - 1);
        newTree.right = bisect(nums, mid + 1, right);
        return newTree;
    }
}