package listNode.两两交换链表中的节点;

import listNode.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = head.next;
        ListNode pre = null;
        while (head != null && head.next != null) {
            ListNode cur = head.next;
            ListNode next = cur.next;
            if(pre!=null) pre.next = cur;
            cur.next = head;
            head.next = next;
            pre = head;
            head = next;
        }
        return res;
    }
}