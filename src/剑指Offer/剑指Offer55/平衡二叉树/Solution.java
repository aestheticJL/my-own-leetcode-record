/*
剑指 Offer 55 - II. 平衡二叉树
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。



示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。
###解题思路
递归，左右子树平衡并且差不超过1即为平衡二叉树
 */
package 剑指Offer.剑指Offer55.平衡二叉树;

import tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int leftHeight = helper(root.left);
            int rightHeight = helper(root.right);
            int diff = leftHeight - rightHeight;
            return diff<=1&&diff>=-1&&isBalanced(root.left)&&isBalanced(root.right);
        }
    }
    public int helper(TreeNode root){
        if (root == null) {
            return 0;
        } else {
            int leftHeight = helper(root.left);
            int rightHeight = helper(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}