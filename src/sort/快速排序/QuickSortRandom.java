package sort.快速排序;

import java.util.Random;

public class QuickSortRandom {
    public static void quickSort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    public static void helper(int[] nums, int left, int right) {
        if (left >= right) return;
        int ran = left + new Random().nextInt(right - left);
        int key = nums[ran];
        nums[ran] = nums[left];
        nums[left] = key;
        int low = left;
        int high = right;
        while (low < high) {
            while (low < high && nums[high] >= key) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= key) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = key;
        helper(nums, left, low - 1);
        helper(nums, low + 1, right);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        quickSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
