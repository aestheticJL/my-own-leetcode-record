package competition.网易20年8月8日笔试.C;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int min;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int k = 0; k < T; k++) {
            min = Integer.MAX_VALUE;
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            dfs(nums, 0, nums.length - 1);
            System.out.println(min);
        }
    }

    public static void dfs(int[] nums, int left, int right) {
        min = Math.min(sum(nums, left, left - 1, right + 1, right), min);
        if (left >= right) return;
        int a = nums[left];
        int b = nums[right];
        int low = left;
        int high = right;
        while (low < high) {
            if (a == b) {
                min = Math.min(sum(nums, left, low, high, right), min);
                low++;
                if (low < high) a += nums[low];
            } else if (a < b) {
                low++;
                if (low < high) a += nums[low];
            } else {
                high--;
                if (low < high) b += nums[high];
            }
        }
        dfs(nums, left + 1, right);
        dfs(nums, left, right - 1);
    }

    public static int sum(int[] nums, int left, int low, int high, int right) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i >= left && i <= low) || (i >= high) && (i <= right)) continue;
            res += nums[i];
        }
        return res;
    }
}
