/*
剑指 Offer 22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。



示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
###解题思路
借助堆栈
执行用时：2 ms, 在所有 Java 提交中击败了16.05%的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了100.00%的用户

也可以双指针，一个先走k-1步，然后两个一起走，快指针出现null，慢指针出结果
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37.5 MB, 在所有 Java 提交中击败了
100.00%的用户
 */
package 剑指Offer.剑指Offer22.链表中倒数第k个节点;

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
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int i = 1;
        while (i < k) {
            stack.pop();
            i++;
        }
        return stack.pop();
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (i < k) {
            fast = fast.next;
            i++;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}