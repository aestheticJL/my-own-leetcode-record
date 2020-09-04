/*
257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
###解题思路
dfs
执行用时：8 ms, 在所有 Java 提交中击败了57.08%的用户
内存消耗：39.9 MB, 在所有 Java 提交中击败了51.50%的用户
 */
package tree.二叉树的所有路径;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList();
        if (root == null) return res;
        StringBuilder sb = new StringBuilder(root.val + "->");
        dfs(root, sb);
        return res;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.delete(sb.length() - 2, sb.length());
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        if (root.left != null) {
            dfs(root.left, sb.append(root.left.val + "->"));
            sb = new StringBuilder(sb.substring(0, len));
        }
        if (root.right != null) {
            dfs(root.right, sb.append(root.right.val + "->"));
            sb = new StringBuilder(sb.substring(0, len));
        }
    }
}