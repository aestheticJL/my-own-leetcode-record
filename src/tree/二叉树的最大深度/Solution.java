/*
104. 二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
###解题思路
层序遍历，每一层res++；
执行用时：1 ms, 在所有 Java 提交中击败了17.33%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了5.75%的用户

递归，一棵树深度等于左子树和右子树较为深一棵深度+1；
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了5.75%的用户
 */
package tree.二叉树的最大深度;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            if (count > 0) res++;
            while (count > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                count--;
            }
        }
        return res;
    }
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}