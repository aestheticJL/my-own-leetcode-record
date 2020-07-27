/*
剑指 Offer 32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。



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
  [20,9],
  [15,7]
]


提示：

节点总数 <= 1000
###解题思路
执行用时：1 ms, 在所有 Java 提交中击败了99.67%的用户
内存消耗：40.2 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer32.从上到下打印二叉树3;

import tree.TreeNode;

import java.util.*;

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
        boolean flag = true;
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
            if (flag) {
                res.add(newList);
                flag = false;
            } else {
                List<Integer> reverseList = new ArrayList();
                for (int i = 0; i < newList.size(); i++) {
                    reverseList.add(newList.get(newList.size() - i - 1));
                }
                res.add(reverseList);
                flag = true;
            }
        }
        return res;
    }
}