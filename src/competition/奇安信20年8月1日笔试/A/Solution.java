package competition.奇安信20年8月1日笔试.A;

import java.util.*;

public class Solution {
    static int max;
    static int count;

    public static void main(String[] args) {
        max = 0;
        Scanner in = new Scanner(System.in);
        count = in.nextInt();
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int key = in.nextInt();
            int value = in.nextInt();
            map.put(key, value);
            list.add(key);
        }
        int money = 0;
        int sum = 0;
        if (count > 50000) {
            double temp = 0;
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                double key = (double) list.get(i);
                double val = (double) map.get(list.get(i));
                if (val / key > temp) {
                    temp = val / key;
                    index = i;
                }
            }
            int total = count / list.get(index);
            money = total * list.get(index);
            sum = total * map.get(list.get(index));
            Collections.sort(list);
            dfs(map, list, money, sum);
        } else {
            Collections.sort(list);
            dfs(map, list, money, sum);
        }
        System.out.println(max);
    }

    public static void dfs(Map<Integer, Integer> map, List<Integer> list, int money, int sum) {
        max = max > sum ? max : sum;
        for (int i = 0; i < list.size(); i++) {
            Integer key = list.get(i);
            Integer value = map.get(key);
            money += key;
            sum += value;
            if (money <= count) dfs(map, list, money, sum);
            else break;
            money -= key;
            sum -= value;
        }
    }
}

