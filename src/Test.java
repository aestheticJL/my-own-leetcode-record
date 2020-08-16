import java.io.Serializable;
import java.util.*;

public class Test implements Serializable {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>((o1, o2) -> o1 - o2);
        List list = new ArrayList();
        list.add(4);
        list.add(22);
        list.add(14);
        list.add(12);
        list.add(10);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(1, 10);
        map.put(6, 6);
        map.put(7, 7);
        System.out.println(Collections.min(list));
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
