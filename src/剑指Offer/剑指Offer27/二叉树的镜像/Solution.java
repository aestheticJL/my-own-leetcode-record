/*
剑指 Offer 27. 二叉树的镜像
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1



示例 1：

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]


限制：

0 <= 节点个数 <= 1000
###解题思路
递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：36.7 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer27.二叉树的镜像;

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
    public TreeNode mirrorTree(TreeNode root) {
        return helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = helper(root.right);
        root.right = helper(temp);
        return root;
    }
}