/*
  路径总和
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
###解题思路
两边搜索汇总即可
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了6.52%的用户
 */
package tree.路径总和;

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        int total = 0;
        return search(total, sum, root);
    }

    public boolean search(int total, int sum, TreeNode temp) {
        if (temp == null) return false;
        total += temp.val;
        if (total == sum && temp.left == null && temp.right == null) return true;
        return search(total, sum, temp.left) || search(total, sum, temp.right);
    }
}