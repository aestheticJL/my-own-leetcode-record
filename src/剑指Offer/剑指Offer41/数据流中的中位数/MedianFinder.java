/*
剑指 Offer 41. 数据流中的中位数
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例 1：

输入：
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
输出：[null,null,null,1.50000,null,2.00000]
示例 2：

输入：
["MedianFinder","addNum","findMedian","addNum","findMedian"]
[[],[2],[],[3],[]]
输出：[null,null,2.00000,null,2.50000]
###解题思路
使用一个大顶堆和一个小顶堆
小顶堆，存放数组中较为大的一半
大顶堆，存放数组中较为小的一半
两个堆大小相同时，堆顶就是两个最中间的数，否则，取较大的那一堆堆顶
执行用时：71 ms, 在所有 Java 提交中击败了96.09%的用户
内存消耗：51.2 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer41.数据流中的中位数;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> smallHeap = new PriorityQueue<>();//小顶堆，存放数组中较为大的一半
    Queue<Integer> bigHeap = new PriorityQueue<>((x, y) -> (y - x));//大顶堆，存放数组中较为小的一半
    //两个堆大小相同时，堆顶就是两个最中间的数，否则，取较大的那一堆堆顶
    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        // 第一次加入默认加到小顶堆
        if (smallHeap.size() == 0 && bigHeap.size() == 0) {
            smallHeap.offer(num);
            return;
        }
        if (smallHeap.size() == bigHeap.size()) {
            // 两者大小相同的时候，根据堆顶数据的大小执行入队
            if (smallHeap.peek() < num) smallHeap.offer(num);
            else bigHeap.offer(num);
        } else if (smallHeap.size() > bigHeap.size()) {
            // 当小顶堆数据较多时，如果num小于小顶堆堆顶数据，那么num直接加入大顶堆
            if (num < smallHeap.peek()) bigHeap.offer(num);
            else {
                // 否则需要执行一次大小顶堆的转换操作
                bigHeap.offer(smallHeap.poll());
                smallHeap.offer(num);
            }
        } else {
            if (num > bigHeap.peek()) smallHeap.offer(num);
            else {
                smallHeap.offer(bigHeap.poll());
                bigHeap.offer(num);
            }
        }
    }

    public double findMedian() {
        if (smallHeap.size() + bigHeap.size() == 0) return 0;
        double res;
        if (smallHeap.size() == bigHeap.size()) {
            res = smallHeap.peek() + bigHeap.peek();
            res /= 2;
        } else {
            if (smallHeap.size() > bigHeap.size()) {
                res = smallHeap.peek();
            } else {
                res = bigHeap.peek();
            }
        }
        return res;
    }
}
