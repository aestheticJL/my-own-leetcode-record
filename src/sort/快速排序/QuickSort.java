/*
手写的快排练习
 */
package sort.快速排序;

public class QuickSort {
    public static void quickSort(int array[], int right, int left) {
        if (right < left) {
            return;
        }
        int key = array[left];
        int high = right;
        int low = left;
        while (low < high) {
            while (key <= array[high] && low < high) {
                high--;
            }
            array[low] = array[high];
            while (key >= array[low] && low < high) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = key;
        quickSort(array, right, high + 1);
        quickSort(array, high - 1, left);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        int len = arr.length - 1;
        quickSort(arr, len, 0);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
