/*
106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
###解题思路
递归
执行用时：13 ms, 在所有 Java 提交中击败了10.44%的用户
内存消耗：89 MB, 在所有 Java 提交中击败了5.02%的用户
 */
package tree.从中序与后序遍历序列构造二叉树;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 1) return new TreeNode(inorder[0]);
        if (inorder.length == 0) return null;
        int mid = postorder[postorder.length - 1];
        int index = 0;
        while (true) {
            if (index == inorder.length) {
                index--;
                break;
            }
            if (inorder[index] == mid) break;
            index++;
        }
        TreeNode treeNode = new TreeNode(mid);
        if (index == 0) treeNode.left = null;
        else
            treeNode.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        if (index == inorder.length - 1) treeNode.right = null;
        else
            treeNode.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));
        return treeNode;
    }
}