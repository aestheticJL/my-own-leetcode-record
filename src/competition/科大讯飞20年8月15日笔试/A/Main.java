package competition.科大讯飞20年8月15日笔试.A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] map = new int[n][m];
        int max = 0;
        int[] index = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
                if (map[i][j] > max) {
                    index = new int[]{i, j};
                    max = map[i][j];
                }
            }
        }
        int max2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == index[0] || j == index[1]) continue;
                if (map[i][j] > max2) {
                    max2 = map[i][j];
                }
            }
        }
        int second1 = 0;
        for (int i = 0; i < n; i++) {
            if (i == index[0]) continue;
            if (map[i][index[1]] > second1) second1 = map[i][index[1]];
        }
        int second2 = 0;
        for (int i = 0; i < m; i++) {
            if (i == index[1]) continue;
            if (map[index[0]][i] > second2) second2 = map[index[0]][i];
        }
        int res = Math.max(max * max2, second1 * second2);
        System.out.println(res);
    }
}