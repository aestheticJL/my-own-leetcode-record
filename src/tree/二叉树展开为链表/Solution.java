/*
114. 二叉树展开为链表
给定一个二叉树，原地将它展开为一个单链表。



例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
###解题思路
前序遍历，记录链表
执行用时：2 ms, 在所有 Java 提交中击败了9.94%的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了96.18%的用户

边遍历边展开
执行用时：1 ms, 在所有 Java 提交中击败了33.60%的用户
内存消耗：39.4 MB, 在所有 Java 提交中击败了75.14%的用户
 */
package tree.二叉树展开为链表;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList();
        List<TreeNode> list = new ArrayList();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                list.add(temp);
                temp = temp.left;
            } else {
                TreeNode pop = stack.pop();
                if (pop.right != null) temp = pop.right;
            }
        }
        for (int i = 1; i < list.size(); i++) {
            root.right = list.get(i);
            root.left = null;
            root = root.right;
        }
    }

    public void flatten2(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pre != null) {
                pre.right = pop;
                pre.left = null;
            }
            if (pop.left != null) stack.push(pop.left);
            if (pop.right != null) stack.push(pop.right);
            pre = pop;
        }
    }
}