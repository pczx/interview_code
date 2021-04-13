package leetcode;

import java.util.*;

public class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list = map.getOrDefault(new String(chars), new ArrayList<>());
            list.add(str);
            map.put(new String(chars), list);
        }
        return new ArrayList<>(map.values());
    }
}
