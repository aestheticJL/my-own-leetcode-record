/*
剑指 Offer 36. 二叉搜索树与双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。



为了让您更好地理解问题，以下面的二叉搜索树为例：

我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
###解题思路
直接中序遍历存储节点再一个个拿出来
执行用时：3 ms, 在所有 Java 提交中击败了5.60%的用户
内存消耗：39.8 MB, 在所有 Java 提交中击败了100.00%的用户

原地算法
执行用时：1 ms, 在所有 Java 提交中击败了18.30%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer36.二叉搜索树与双向链表;

import java.util.Deque;
import java.util.LinkedList;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class Solution {
    Node head = null;
    Node temp = head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        head.left = temp;
        temp.right = head;
        return head;
    }

    public void helper(Node root) {
        Deque<Node> stack = new LinkedList();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (temp == null) {
                head = node;
                temp = node;
            } else {
                temp.right = node;
                node.left = temp;
                temp = node;
            }
            if (node.right != null) {
                helper(node.right);
            }
        }
    }
}