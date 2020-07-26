/*
剑指 Offer 25. 合并两个排序的链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000
###解题思路
判断即可
执行用时：1 ms, 在所有 Java 提交中击败了99.44%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer25.合并两个排序的链表;

import listNode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            } else {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
        }
        if (l1 == null && l2 != null) {
            temp.next = l2;
        } else if (l2 == null && l1 != null) {
            temp.next = l1;
        }
        return head.next;
    }
}