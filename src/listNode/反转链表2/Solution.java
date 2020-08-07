/*
92. 反转链表 II
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
###解题思路
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：37.6 MB, 在所有 Java 提交中击败了18.37%的用户
 */
package listNode.反转链表2;

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode begin = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        int sum = n - m;
        while (m != 1) {
            pre = begin;
            begin = begin.next;
            m--;
        }
        ListNode temp = begin;
        ListNode cur = begin.next;
        while (sum > 0) {
            ListNode next = cur.next;
            cur.next = temp;
            temp = cur;
            cur = next;
            sum--;
        }
        pre.next = temp;
        begin.next = cur;
        return pre.next;
    }
}