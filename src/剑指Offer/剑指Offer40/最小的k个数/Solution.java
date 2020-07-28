/*
剑指 Offer 40. 最小的k个数
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。



示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]


限制：

0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000
###
堆排序
执行用时：4 ms, 在所有 Java 提交中击败了72.16%的用户
内存消耗：40.4 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer40.最小的k个数;

class Solution {
    int[] heap;

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = arr[i];
        }
        int last = heap.length / 2 - 1;
        for (int i = last; i >= 0; i--) {
            sortHeap(i);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heap[0]) {
                heap[0] = arr[i];
                sortHeap(0);
            }
        }
        return heap;
    }

    private void sortHeap(int index) {
        int l = heap.length;
        int mid = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < l && heap[left] > heap[mid]) {
            mid = left;
        }
        if (right < l && heap[right] > heap[mid]) {
            mid = right;
        }
        if (mid != index) {
            int temp = heap[index];
            heap[index] = heap[mid];
            heap[mid] = temp;
            sortHeap(mid);
        }
    }
}