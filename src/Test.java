import java.util.*;

public class Test {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(1, 1);
        map.put(6, 6);
        map.put(7, 7);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getValue());
        }
        map.remove(map.firstKey());
        Set<Map.Entry<Integer, Integer>> entries2 = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries2) {
            System.out.println(entry.getValue());
        }
    }
}
