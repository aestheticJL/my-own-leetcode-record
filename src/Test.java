import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Test implements Comparable {
    public static void main(String[] args) {
        int[] inorder = new int[2];
        inorder[1] = 1;
        inorder[0] = 0;
        int index = 1;
        int[] x = Arrays.copyOfRange(inorder, 0, index - 1);
        System.out.println(x[0]);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
