/*
现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，若不存在则输出 -1。
 */
package other.位数之积;

import java.util.*;


public class Solution {
    /**
     * 输入一个整形数值，返回一个整形值
     *
     * @param n int整型 n>9
     * @return int整型
     */
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        int res = 0;
        int pow = 1;
        while (n > 9) {
            int temp = n;
            for (int i = 9; i > 1; i--) {
                if (n % i == 0) {
                    res += i * pow;
                    pow *= 10;
                    n /= i;
                    break;
                }
            }
            if (temp == n) {
                return -1;
            }
        }
        res += n * pow;
        return res;
    }
}