package sort.冒泡排序;

public class BubbleSort {
    public static void BubbleSort(int[] nums) {
        int length = nums.length;
        int right = length - 1;
        int nextRight = right;
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < right; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                    nextRight = j;
                }
            }
            right = nextRight;//右边界，即最后一次交换的位置，后面不再有交换即有序
            if (!flag) break;//如果没有任何交换，说明已经有序，跳出循环
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        BubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
