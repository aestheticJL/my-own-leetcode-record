package sort.堆排序;

public class HeadSort {
    public static void main(String[] args) {
        int[] nums = {122344, 4656, 34, 34, 4656, 5, 6, 1,7, 8, 9, 343, 57765, 23, 123, 21, 3, 3, 3, 7, 9,};
        bulidHead(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 堆排序
     */
    public static void bulidHead(int[] nums) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (nums.length) / 2; i >= 0; i--) {
            sortHead(nums, i, nums.length);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = nums.length - 1; i >= 1; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            sortHead(nums, 0, i);
        }
    }

    private static void sortHead(int[] nums, int index, int length) {
        int left = index * 2;
        int right = index * 2 + 1;
        int key = nums[index];
        int temp = index;
        if (left < length && nums[left] > nums[temp]) {
            temp = left;
        }
        if (right < length && nums[right] > nums[temp]) {
            temp = right;
        }
        if (temp == index) {
            return;
        } else {
            nums[index] = nums[temp];
            nums[temp] = key;
            sortHead(nums, temp, length);
        }
    }
}
