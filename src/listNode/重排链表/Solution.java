/*
重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
###解题思路
先使用快慢指针，把链表一分为二，之后反转后半部分，依次插入即可
 */
package listNode.重排链表;

import listNode.ListNode;

class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode start = slow.next;
        slow.next = null;
        ListNode pre = null;
        while (start!=null){
            ListNode temp = start.next;
            start.next = pre;
            pre = start;
            start = temp;
        }
        ListNode begin = head;
        while (pre!=null){
            ListNode temp = begin.next;
            begin.next = pre;
            ListNode preNext = pre.next;
            pre.next = temp;
            begin = temp;
            pre = preNext;
        }
    }
}