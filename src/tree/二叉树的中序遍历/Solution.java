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
    ArrayList<Integer> res;

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root.left != null) {
            stack.push(root.left);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode tempTreeNode = stack.pop();
            res.add(tempTreeNode.val);
            if (tempTreeNode.right != null) helper(tempTreeNode.right);
        }
    }
}