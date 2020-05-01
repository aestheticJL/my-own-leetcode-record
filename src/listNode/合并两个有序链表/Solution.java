/*
合并两个有序链表
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
###解题思路
简单循环判断即可
执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗 :38.7 MB, 在所有 Java 提交中击败了71.03%的用户
 */
package listNode.合并两个有序链表;

import listNode.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
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
        if (l1 == null && l2 != null) temp.next = l2;
        if (l2 == null && l1 != null) temp.next = l1;
        return result.next;
    }
}