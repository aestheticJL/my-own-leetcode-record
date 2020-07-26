/*
剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。



示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL


限制：

0 <= 节点个数 <= 5000
###解题思路
使用栈
执行用时：2 ms, 在所有 Java 提交中击败了6.70%的用户
内存消耗：39.9 MB, 在所有 Java 提交中击败了100.00%的用户

使用双指针
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了s100.00%的用户
 */
package 剑指Offer.剑指Offer24.反转链表;

import listNode.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while (!stack.isEmpty()) {
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }
        return res.next;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}