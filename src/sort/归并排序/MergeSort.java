package sort.归并排序;

public class MergeSort {
    public static int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) return new int[]{nums[start]};
        int mid = start + (end - start) / 2;
        int[] array1 = mergeSort(nums, start, mid);
        int[] array2 = mergeSort(nums, mid + 1, end);
        return merge(array1, array2);
    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] res = new int[array1.length + array2.length];
        int index = 0;
        int first = 0;
        int second = 0;
        while (first < array1.length && second < array2.length) {
            if (array1[first] >= array2[second]) {
                res[index] = array2[second];
                index++;
                second++;
            } else {
                res[index] = array1[first];
                index++;
                first++;
            }
        }
        while (first < array1.length) {
            res[index] = array1[first];
            index++;
            first++;
        }
        while (second < array2.length) {
            res[index] = array2[second];
            index++;
            second++;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 3, 3, 7, 9, 1, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        int[] newArray = mergeSort(arr, 0, arr.length - 1);
        for (int i : newArray) {
            System.out.println(i);
        }
    }
}
