/*
剑指 Offer 32 - II. 从上到下打印二叉树 II
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]


提示：

节点总数 <= 1000
###解题思路
执行用时：1 ms, 在所有 Java 提交中击败了93.37%的用户
内存消耗：39.9 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer32.从上到下打印二叉树2;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> newList = new ArrayList();
            int count = queue.size();
            while (count != 0) {
                TreeNode t = queue.poll();
                newList.add(t.val);
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
                count--;
            }
            res.add(newList);
        }
        return res;
    }
}