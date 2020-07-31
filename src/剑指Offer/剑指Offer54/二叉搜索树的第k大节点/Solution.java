/*
剑指 Offer 54. 二叉搜索树的第k大节点
给定一棵二叉搜索树，请找出其中第k大的节点。



示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4


限制：

1 ≤ k ≤ 二叉搜索树元素个数
###解题思路
因为找第k大，右根左的中序遍历。
反之左根右
执行用时：1 ms, 在所有 Java 提交中击败了45.42%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer54.二叉搜索树的第k大节点;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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
    int count;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        Deque<TreeNode> stack = new LinkedList();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {
                TreeNode treeNode = stack.poll();
                count--;
                if (count == 0) {
                    return treeNode.val;
                }
                root = treeNode.left;
            }
        }
        return 0;
    }
}