/*
 K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。



示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5



说明：

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
###解题思路
首先确定链表长度然后分组，对每组进行反转然后前后连接，反转思路参考反转链表。
执行用时 :1 ms, 在所有 Java 提交中击败了57.68%的用户
内存消耗 :40 MB, 在所有 Java 提交中击败了7.32%的用户
 */
package listNode.K个一组翻转链表;

import listNode.ListNode;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int sum = 0;
        ListNode temp = head;
        while (temp != null) {
            sum++;
            temp = temp.next;
        }
        int group = sum / k;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode curr = head;
        ListNode prev = null;
        for (int i = 0; i < group; i++) {
            for (int j = 0; j < k; j++) {
                ListNode tempNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tempNode;
            }
            if (i == 0) head = prev;
            ListNode newStart = start.next;
            newStart.next = curr;
            start.next = prev;
            start = newStart;
        }
        return head;
    }
}