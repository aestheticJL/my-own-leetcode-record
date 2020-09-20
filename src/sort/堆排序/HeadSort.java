package sort.堆排序;

public class HeadSort {
    public static void main(String[] args) {
        int[] nums = {
                0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,43,21,
                22,16,12,1,19,15,5,18,2,2,22,15,8,22,
                17,6,22,6,22,26,32,8,10,11,2,26,9,12,
                9,72,28,33,20,7,2,17,44,3,52,27,2,23,
                19,56,56,58,36,31,1,19,19,6,65,49,27,
        };
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
        for (int i = (nums.length) / 2 - 1; i >= 0; i--) {
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
        int left = index * 2 + 1;
        int right = index * 2 + 2;
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
