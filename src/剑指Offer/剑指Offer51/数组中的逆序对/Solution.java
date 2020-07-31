/*
剑指 Offer 51. 数组中的逆序对
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。



示例 1:

输入: [7,5,6,4]
输出: 5


限制：

0 <= 数组长度 <= 50000
###解题思路
技巧题，理解为一个归并排序即可解答
执行用时：31 ms, 在所有 Java 提交中击败了98.56%的用户
内存消耗：49.7 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer51.数组中的逆序对;

class Solution {
    int res;

    public int reversePairs(int[] nums) {
        if (nums.length == 0 && nums == null) return 0;
        res = 0;
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    public int[] mergeSort(int[] nums, int left, int right) {
        if (left == right) return new int[]{nums[left]};
        int mid = left + (right - left) / 2;
        int[] arr1 = mergeSort(nums, left, mid);
        int[] arr2 = mergeSort(nums, mid + 1, right);
        int[] arr = merge(arr1, arr2);
        return arr;
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int first = 0;
        int second = 0;
        int[] arr = new int[arr1.length + arr2.length];
        int index = 0;
        while (first < arr1.length && second < arr2.length) {
            if (arr1[first] > arr2[second]) {
                arr[index] = arr2[second];
                res += arr1.length - first;
                index++;
                second++;
            } else {
                arr[index] = arr1[first];
                index++;
                first++;
            }
        }
        while (first >= arr1.length && second < arr2.length) {
            arr[index] = arr2[second];
            index++;
            second++;
        }
        while (first < arr1.length && second >= arr2.length) {
            arr[index] = arr1[first];
            index++;
            first++;
        }
        return arr;
    }
}