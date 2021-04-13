package solution;

import java.util.*;

public class NC97 {

    public String[][] topKstrings(String[] strings, int k) {
        // write code here
        String[][] ans = new String[k][];
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            int cnt = map.getOrDefault(s, 0);
            map.put(s, cnt + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            ans[i] = new String[]{entry.getKey(), entry.getValue().toString()};
        }
        return ans;
    }
}
