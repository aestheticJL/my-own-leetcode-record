package competition.五八同城20年8月31日.A;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    /**
     * @param values string字符串ArrayList<ArrayList<>>
     * @return string字符串ArrayList
     */
    public ArrayList<String> findCommonString(ArrayList<ArrayList<String>> values) {
        int size = values.size();
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            List<String> temp = values.get(i).stream().distinct().collect(Collectors.toList());
            for (String s : temp) {
                Integer v = map.getOrDefault(s, 0);
                map.put(s, v + 1);
                if (v + 1 == size) res.add(s);
            }
        }
        return res;
    }
}
