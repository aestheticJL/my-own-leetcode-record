package array.中间数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> solution(int[] nums) {
        List<Integer> res = new ArrayList();
        int leftMax = Integer.MIN_VALUE;
        int rightMin = Integer.MAX_VALUE;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = Integer.MAX_VALUE;
        right[nums.length-1] = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (leftMax >= nums[i]) {
                left[i] = leftMax;
            } else {
                left[i] = nums[i];
                leftMax = nums[i];
            }
            if (rightMin <= nums[nums.length - 1 - i]) {
                right[nums.length - 1 - i] = rightMin;
            } else {
                right[nums.length - 1 - i] = nums[nums.length - 1 - i];
                rightMin = nums[nums.length - 1 - i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] < right[i + 1]) res.add(nums[i]);
                continue;
            }
            if (i == nums.length - 1) {
                if (nums[i] > left[i - 1]) res.add(nums[i]);
                continue;
            }
            if (nums[i] < right[i + 1] && nums[i] > left[i - 1]) res.add(nums[i]);
        }
        for (Integer re : res) {
            System.out.println(re);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{5, 4, 18, 19, 24, 20});
    }
}
