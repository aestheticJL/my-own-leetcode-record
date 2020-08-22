/*
234. 回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
###解题思路
先用快慢指针找到中点，然后反转后半部分
执行用时：1 ms, 在所有 Java 提交中击败了99.75%的用户
内存消耗：42.2 MB, 在所有 Java 提交中击败了88.18%的用户
 */
package listNode.回文链表;

import listNode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = slow;
        slow = slow.next;
        pre.next = null;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        while(head != null){
            if(pre.val!=head.val) return false;
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}