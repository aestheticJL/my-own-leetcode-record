package heap.topN;

import java.util.Random;

public class topN {
    public static final int top = 100;
    public static final int count = 100000000;
    public static final int[] topN = new int[top];
    public static final int[] array = new int[count];

    public static void buildHeap() {
        for (int i = 0; i < top; i++) {
            topN[i] = array[i];
        }
        int mid = top / 2 - 1;
        for (int i = mid; i >= 0; i--) {
            sortHeap(i);
        }
    }

    public static void sortHeap(int index) {
        int left = index * 2;
        int right = index * 2 + 1;
        int temp = index;
        if (left < top && topN[left] < topN[temp]) {
            temp = left;
        }
        if (right < top && topN[right] < topN[temp]) {
            temp = right;
        }
        if (temp != index) {
            int tempNum = topN[index];
            topN[index] = topN[temp];
            topN[temp] = tempNum;
            sortHeap(temp);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < count; i++) {
            array[i] = new Random().nextInt(999999999);
        }
        buildHeap();
        for (int i = top; i < count; i++) {
            if (array[i] > topN[0]) {
                topN[0] = array[i];
                sortHeap(0);
            }
        }
        for (int i : topN) {
            System.out.println(i);
        }
    }
}
