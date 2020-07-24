/*
剑指 Offer 07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。



例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7


限制：

0 <= 节点个数 <= 5000
###解题思路
递归法
执行用时：15 ms, 在所有 Java 提交中击败了11.07%的用户
内存消耗：90.8 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer07.重建二叉树;

import tree.TreeNode;

import java.util.Arrays;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        int midValue = preorder[0];
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == midValue) {
                mid = i;
                break;
            }
        }
        TreeNode newTreeNode = new TreeNode(midValue);
        int[] left = Arrays.copyOfRange(inorder, 0, mid);
        int[] right = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        newTreeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, left.length + 1), left);
        newTreeNode.right = buildTree(Arrays.copyOfRange(preorder, left.length + 1, preorder.length), right);
        return newTreeNode;
    }
}