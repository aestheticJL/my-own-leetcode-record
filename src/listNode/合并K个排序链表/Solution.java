/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * ###解题思路
 * 采用分治法，两两链表合并
 * 执行用时 :3 ms, 在所有 Java 提交中击败了84.93%的用户
 * 内存消耗 :42.3 MB, 在所有 Java 提交中击败了38.23%的用户
 */
package listNode.合并K个排序链表;

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
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newList;
        if (l1.val < l2.val) {
            newList = l1;
            newList.next = merge(l1.next, l2);
        } else {
            newList = l2;
            newList.next = merge(l1, l2.next);
        }
        return newList;
    }

    public ListNode bisect(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = bisect(lists, left, mid);
        ListNode l2 = bisect(lists, mid + 1, right);
        return merge(l1, l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return null;
        return bisect(lists, 0, lists.length - 1);
    }
}