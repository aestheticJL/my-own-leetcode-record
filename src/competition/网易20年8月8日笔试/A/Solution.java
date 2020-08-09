package competition.网易20年8月8日笔试.A;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long res = 0;
        while (in.hasNext()) {
            res += in.nextInt() / 2;
        }
        System.out.println(res);
    }
}