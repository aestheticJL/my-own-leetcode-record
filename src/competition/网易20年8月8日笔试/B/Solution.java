package competition.网易20年8月8日笔试.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int vis[] = new int[n + 1];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            res.add(num);
            vis[num] = 1;
        }
        boolean flag = false;
        int index = 0;
        for (int i = 1; i < vis.length; i++) {
            if (vis[i] != 1) {
                if (flag) {
                    res.add(i);
                    continue;
                }
                while (index < res.size() && res.get(index) < i) {
                    index++;
                }
                if (index == res.size()) {
                    flag = true;
                }
                res.add(index, i);
            }
        }
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }
}