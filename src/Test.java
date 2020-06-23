import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test implements InvocationHandler {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap();
        map.put(1, null);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, null);
        map.put(5, 50);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

//        Map<Integer, Integer> newMap = map.entrySet().stream().filter(e -> e.getValue() != null).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        System.out.println(map.toString());
//        System.out.println(newMap.toString());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
