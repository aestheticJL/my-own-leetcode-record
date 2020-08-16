package competition.科大讯飞20年8月15日笔试.D;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        int n = in.nextInt();
        while (n > 0) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            n--;
        }
        System.out.println(sb.toString());
    }
}