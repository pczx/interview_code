package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class leetcode884 {
    public String[] uncommonFromSentences(String A, String B) {
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : A.split(" ")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : B.split(" ")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                ans.add(key);
            }
        }
        return ans.toArray(new String[0]);
    }
}
