package sort.希尔排序;

public class ShellSort {
    public static void ShellSort(int[] nums) {
        int length = nums.length;
        for (int step = length / 2; step > 0; step /= 2) {//步长
            System.out.println("step:" + step);
            for (int i = step; i < length; i++) {//这里走的是插入排序
                int key = nums[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (key >= nums[j]) {//如果key大于等于nums[j]即找到了插入位置
                        break;
                    } else {
                        nums[j + step] = nums[j];
                    }
                }
                nums[j + step] = key;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 3, 3, 7, 9, 1, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        ShellSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
