/*
从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
###解题思路
划分左右子树递归调用
preorder第一个节点为根节点，在inorder中寻找到该节点（下标i），左边[9]即为左子树，右边[15,20,7]即为右子树，
左子树长度为i+1，右子树长度为len-i+1
 */
package tree.从前序与中序遍历序列构造二叉树;

import tree.TreeNode;

import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                //划分左右子树递归调用
                //preorder第一个节点为根节点，在inorder中寻找到该节点（下标i），左边[9]即为左子树，右边[15,20,7]即为右子树，
                //左子树长度为i+1，右子树长度为len-i+1
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
                break;
            }
        }
        return root;
    }
}