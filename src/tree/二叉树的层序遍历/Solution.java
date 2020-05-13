/*
二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



示例：
二叉树：[3,9,20,null,null,15,7],

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
###解题思路
利用队列来记录下一层节点，为空则遍历结束。
执行用时 :2 ms, 在所有 Java 提交中击败了22.74%的用户
内存消耗 :39.8 MB, 在所有 Java 提交中击败了5.71%的用户
 */
package tree.二叉树的层序遍历;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> newList = new ArrayList<>();
            for (TreeNode treeNode : queue) {
                if (treeNode!=null)
                    newList.add(treeNode.val);
            }
            res.add(newList);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null)
                    queue.offer(poll.left);
                if (poll.right!=null)
                    queue.offer(poll.right);
            }
        }
        return res;
    }
}