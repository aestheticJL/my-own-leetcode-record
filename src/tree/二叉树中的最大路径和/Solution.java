/*
 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42
###解决思路
使用递归，对于每个节点，考虑其左右子节点带来的收益，大于0即走，否则不动。
对于二叉树来说，每一个节点都可能作为中转节点，递归的同时更新res。
执行用时：1 ms, 在所有 Java 提交中击败了99.55%的用户
内存消耗：41.5 MB, 在所有 Java 提交中击败了11.54%的用户
 */
package tree.二叉树中的最大路径和;

import tree.TreeNode;

class Solution {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxChildren(root);
        return res;
    }

    public int maxChildren(TreeNode children) {
        if (children == null) return 0;
        int left = Math.max(0, maxChildren(children.left));//left小于0时不走
        int right = Math.max(0, maxChildren(children.right));//right小于0时不走
        int temp = children.val + left + right;
        res = Math.max(res, temp);//对于以该节点为中转节点和res比较
        return children.val + Math.max(left, right);//返回该节点最大期望值
    }
}