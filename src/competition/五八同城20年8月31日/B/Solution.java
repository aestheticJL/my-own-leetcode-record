package competition.五八同城20年8月31日.B;

public class Solution {
    /**
     * @param a int整型
     * @param b int整型
     * @return int整型
     */
    public int question(int a, int b) {
        for (int i = 0; i <= 500; i++) {
            int first = i + a;
            int second = i + b;
            int firstSqrt = (int)Math.sqrt(first);
            int secondSqrt = (int)Math.sqrt(second);
            if (firstSqrt * firstSqrt == first && secondSqrt * secondSqrt == second) return i;
        }
        return 0;
    }
}