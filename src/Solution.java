class Solution {
    public int minCount(int[] coins) {
        int sum = 0;
        for (int i = 0; i < coins.length;i++){
            sum += (coins[i] + 1) / 2;
        }
        return sum;
    }
}