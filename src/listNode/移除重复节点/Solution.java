/*
面试题 02.01. 移除重复节点
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
示例2:

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
提示：

链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。
进阶：

如果不得使用临时缓冲区，该怎么解决？
###解决方案
利用set来去重；
进阶方案即双重循环暴力去重；
执行用时：6 ms, 在所有 Java 提交中击败了79.61%的用户
内存消耗：41.1 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package listNode.移除重复节点;

import listNode.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet();
        ListNode res = new ListNode(head.val);
        set.add(head.val);
        ListNode temp = res;
        while (head.next != null) {
            if (set.add(head.next.val)) {
                temp.next = new ListNode(head.next.val);
                temp = temp.next;
                head = head.next;
            }else {
                head = head.next;
            }
        }
        return res;
    }
}