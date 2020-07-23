package sort.选择排序;

public class selectionSort {
    public static void selectionSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int min = i;//最小值下标
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;//找到最小值的下标
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;//交换
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
