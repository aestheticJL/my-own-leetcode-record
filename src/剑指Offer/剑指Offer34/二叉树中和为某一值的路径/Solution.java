/*
剑指 Offer 34. 二叉树中和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。



示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]


提示：

节点总数 <= 10000
###解题思路
dfs
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：40.3 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer34.二叉树中和为某一值的路径;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    List<List<Integer>> res = new ArrayList();
    List<Integer> newList = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        int temp = root.val;
        newList.add(root.val);
        dfs(root, sum, temp);
        return res;
    }

    public void dfs(TreeNode root, int sum, int temp) {
        if (root.left == null && root.right == null && sum == temp) res.add(new ArrayList(newList));
        if (root.left != null) {
            temp += root.left.val;
            newList.add(root.left.val);
            dfs(root.left, sum, temp);
            temp -= root.left.val;
            newList.remove(newList.size() - 1);
        }
        if (root.right != null) {
            temp += root.right.val;
            newList.add(root.right.val);
            dfs(root.right, sum, temp);
            temp -= root.right.val;
            newList.remove(newList.size() - 1);
        }
    }
}