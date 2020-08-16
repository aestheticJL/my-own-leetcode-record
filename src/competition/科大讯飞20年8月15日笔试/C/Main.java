package competition.科大讯飞20年8月15日笔试.C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        if (n == Integer.MIN_VALUE) {
            System.out.println(1);
            return;
        }
        int res = 0;
        if (n < 0) {
            n = -n;
            res++;
        }
        for (int i = 0; i < 32; i++) {
            res += (n & 1);
            n >>= 1;
        }
        System.out.print(res);
    }
}