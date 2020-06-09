import com.sun.org.apache.bcel.internal.generic.GOTO;

import java.util.*;

public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        String[] s = new String[1];
        Integer a[] = new Integer[1];
        Arrays.sort(s, (s1, s2) -> s2.length() - s1.length());
        Collections.sort(list, (o1, o2) -> o2 - o1);
        System.out.println(list);
        new Thread(() -> System.out.println("go"));
    }

    public void testgo() {
        List<Integer> list = new ArrayList();
        String[] s = new String[1];
        Integer a[] = new Integer[1];
        synchronized(new test()){
            Arrays.sort(s, (s1, s2) -> s2.length() - s1.length());
            Collections.sort(list, (o1, o2) -> o2 - o1);
            System.out.println(list);
        }
        new Thread(() -> System.out.println("go"));
    }
}
