package competition.牛客20年7月11日.A;

import java.util.*;


public class Solution {
    /**
     * @param x string字符串 字符串从前到后分别是从上到下排列的n张扑克牌
     * @return string字符串
     */
    public String Orderofpoker(String x) {
        int sum = x.length() / 2;
        StringBuilder res = new StringBuilder();
        StringBuilder xsb = new StringBuilder(x);
        while (sum > 0) {
            if (sum == 2 || sum == 3 || sum == 5 || sum == 7) {
                res.append(xsb.substring(0, 2));
                xsb.delete(0, 2);
            } else {
                res.append(xsb.substring(sum * 2 - 2, sum * 2));
                xsb.delete(sum * 2 - 2, sum * 2);
            }
            sum--;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Orderofpoker("3C8D6H3D"));
    }
}