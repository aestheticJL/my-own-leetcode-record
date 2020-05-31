/*
 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
###解题思路
普通的中序遍历递归解法
执行用时 :1 ms, 在所有 Java 提交中击败了50.40%的用户
内存消耗 :38.3 MB, 在所有 Java 提交中击败了5.79%的用户
 */
package tree.二叉树的中序遍历;


import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void MidOrder(TreeNode treeNode, List<Integer> L1) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (treeNode.left != null) {
            stack.push(treeNode.left);
            treeNode = treeNode.left;
        }
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            L1.add(pop.val);
            if (pop.right != null) MidOrder(pop.right, L1);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> L1 = new ArrayList<>();
        MidOrder(root, L1);
        return L1;
    }
}