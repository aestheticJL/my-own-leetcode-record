/*
 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。



例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3


但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
###解题思路
对称二叉树一定是左子树与右子树对称，他们的左右子树也有一样的性质
使用递归思路
执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗 :37.8 MB, 在所有 Java 提交中击败了37.50%的用户
 */
package tree.对称二叉树;

import tree.TreeNode;

class Solution {
    public static boolean judge(TreeNode right, TreeNode left) {
        if (right == null && left == null) return true;
        if (right == null || left == null) return false;
        if (right.val != left.val) return false;
        return judge(right.right, left.left) && judge(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return judge(root.right, root.left);
    }
}