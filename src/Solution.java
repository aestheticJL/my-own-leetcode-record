import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int one = 0;
            int two = 0;
            int three = 0;
            try {
                System.out.println("请输入第一条边");
                one = sc.nextInt();
                System.out.println("请输入第二条边");
                two = sc.nextInt();
                System.out.println("请输入第三条边");
                three = sc.nextInt();
            } catch (Exception e) {
                System.out.println("非法输入");
                return;
            }
            boolean flag = true;
            if (one < 1 || one > 200) {
                System.out.println("第一条边输入不合法");
                flag = false;
            }
            if (two < 1 || two > 200) {
                System.out.println("第二条边输入不合法");
                flag = false;
            }
            if (three < 1 || three > 200) {
                System.out.println("第三条边输入不合法");
                flag = false;
            }
            if (!flag) return;
            int max = Math.max(one, two);
            max = Math.max(max, three);
            if (max * 2 >= one + two + three) {
                System.out.println("不能组成三角形");
                return;
            }
            Set set = new HashSet();
            set.add(one);
            set.add(two);
            set.add(three);
            if (set.size() == 3) {
                System.out.println("组成普通三角形");
            }
            if (set.size() == 2) {
                System.out.println("组成等腰三角形");
            }
            if (set.size() == 1) {
                System.out.println("组成等边三角形");
            }
        }
    }
}