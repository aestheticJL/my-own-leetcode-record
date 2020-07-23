package sort.插入排序;

public class InsertionSort {
    public static void InsertionSort(int[] nums) {
        if (nums.length == 0 || nums == null) return;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i]; //记录当前值
            int j = i - 1;
            for (; j >= 0; j--) {//从当前值往前面找他插入的位置（前面是有序区）
                if (temp >= nums[j]) {//如果当前值大于等于前一个值就是找到了
                    break;
                } else {
                    nums[j + 1] = nums[j];//比当前值大，直接往后挪
                }
            }
            nums[j + 1] = temp;//没找到的情况就是-1+1=0，作为第一个元素
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 3, 3, 7, 1, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        InsertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
