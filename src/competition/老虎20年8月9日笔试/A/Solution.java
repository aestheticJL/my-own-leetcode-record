package competition.老虎20年8月9日笔试.A;

import java.util.Arrays;

public class Solution {
    /**
     * 返回最少需要多少辆车
     *
     * @param trips    int整型二维数组 二维int数组，用于表示一组乘客的行程信息，其中`trip[i]`表示第i组乘客，`trip[i][0]`表示第i组乘客的乘客数量，`trip[i][1]`表示上车站点，`trip[i][2]`表示下车站点。
     * @param capacity int整型 int类型，表示每辆车最多能承载多少名乘客
     * @return int整型
     */
    public int minCarCount(int[][] trips, int capacity) {
        Arrays.sort(trips, (o1, o2) -> o1[1] - o2[1]);
        int[] in = new int[101];
        int[] out = new int[101];
        for (int i = 0; i < trips.length; i++) {
            in[trips[i][1]] += trips[i][0];
            out[trips[i][2]] += trips[i][0];
        }
        int res = 0;
        int total = 0;
        int people = 0;
        for (int i = 1; i < 101; i++) {
            people -= out[i];
            people += in[i];
            if (people > total) {
                int newPeople = people - total;
                int neet = newPeople / capacity;
                if (newPeople % capacity != 0) neet++;
                res += neet;
                total = res * capacity;
            }
        }
        return res;
    }
}