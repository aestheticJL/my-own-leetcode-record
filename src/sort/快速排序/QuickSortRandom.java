package sort.快速排序;

import java.util.Random;

public class QuickSortRandom {
    public static void quickSort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    public static void helper(int[] nums, int left, int right) {
        if (left >= right) return;//指针碰撞，结束
        int ran = left + new Random().nextInt(right - left);//随机取一个元素
        int key = nums[ran];
        nums[ran] = nums[left];
        nums[left] = key;//随机取的元素与左边第一个数交换，其实不取随机元素直接从最左边开始也行，不过无法应对极端情况
        int low = left;
        int high = right;//双指针
        while (low < high) {
            while (low < high && nums[high] >= key) {//从右指针开始，找到第一个比key小的元素
                high--;
            }
            nums[low] = nums[high];//交换
            while (low < high && nums[low] <= key) {//接着从左指针开始，找到第一个比key大的元素
                low++;
            }
            nums[high] = nums[low];//交换
        }
        nums[low] = key;//一轮下来，把一开始取出的key放回去，然后左右分别是小于和大于key元素的集合
        helper(nums, left, low - 1);
        helper(nums, low + 1, right);//分治
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        quickSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
