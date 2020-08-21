package temp.A;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> res = Solution(120);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1) {
                System.out.print("*");
            }
        }
    }

    public static List<Integer> Solution(int num) {
        List<Integer> res = new ArrayList<>();
        int i = 2;
        while (i <= num) {
            if (num % i == 0) {
                res.add(i);
                num = num / i;
                i = 2;
            } else {
                i++;
            }
        }
        return res;
    }
}
