package 剑指Offer.剑指Offer51.数组中的逆序对;

class Solution {
    public int reversePairs(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) dp[i]++;
            }
        }
        int sum = 0;
        for (int i : dp) sum += i;
        return sum;
    }
}