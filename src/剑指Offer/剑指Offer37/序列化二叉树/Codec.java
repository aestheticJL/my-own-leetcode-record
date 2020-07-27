/*
剑指 Offer 37. 序列化二叉树
请实现两个函数，分别用来序列化和反序列化二叉树。

示例:

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
###解题思路

执行用时：24 ms, 在所有 Java 提交中击败了61.66%的用户
内存消耗：41.7 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer37.序列化二叉树;

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) stringBuilder.append("null,");
            else {
                stringBuilder.append(poll.val + ",");
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
        stringBuilder.substring(0, stringBuilder.length() - 1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2) return null;
        String[] split = data.substring(1, data.length() - 1).split(",");
        TreeNode root = getNode(split[0]);
        TreeNode parent = root;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isLeft = true;
        for (int i = 1; i < split.length; i++) {
            TreeNode next = getNode(split[i]);
            if (isLeft) {
                parent.left = next;
                isLeft = false;
            } else {
                parent.right = next;
                isLeft = true;
            }
            if (next != null) {
                queue.add(next);
            }
            if (isLeft) {
                parent = queue.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val) {
        if (val.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));