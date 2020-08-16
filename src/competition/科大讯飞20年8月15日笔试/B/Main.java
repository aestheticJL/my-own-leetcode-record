package competition.科大讯飞20年8月15日笔试.B;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        QuickSort(num, 0, num.length - 1);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
            if (i != num.length) System.out.print(" ");
        }
    }

    public static void QuickSort(int[] num, int left, int right) {
        if (left >= right) return;
        int index = left + new Random().nextInt(right - left);
        int key = num[index];
        num[index] = num[left];
        num[left] = key;
        int low = left;
        int high = right;
        while (low < high) {
            while (low < high && num[high] > key)
                high--;
            num[low] = num[high];
            while (low < high && num[low] < key)
                low++;
            num[high] = num[low];
        }
        num[low] = key;
        QuickSort(num, left, low - 1);
        QuickSort(num, low + 1, right);
    }
}