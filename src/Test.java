import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<Test> list = new ArrayList<>();
        list.add(new Test());
        for (Object o : list) {
            System.out.println(o.getClass());
        }
    }
}
