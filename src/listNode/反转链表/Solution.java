/*
 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
###解题思路
prev为上一个节点（head上一个节点为null），实际上反转即是每一个节点的next指向上一个节点
执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗 :39.7 MB, 在所有 Java 提交中击败了5.06%的用户
 */
package listNode.反转链表;

import listNode.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}