package solution;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class NC93 {

    class LRUCache {

        private int capacity;
        private LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new LinkedHashMap<>(16, 0.75f, true);
        }

        public int get(int key) {
            Integer value = map.get(key);
            return value == null ? -1 : value;
        }

        public void put(int key, int value) {
            map.put(key, value);
            if (map.size() > capacity) {
                map.remove(map.keySet().iterator().next());
            }
        }
    }

    public int[] LRU(int[][] operators, int k) {
        List<Integer> values = new ArrayList<>();
        // write code here
        LRUCache lruCache = new LRUCache(k);
        for (int[] op : operators) {
            if (op[0] == 1) {
                lruCache.put(op[1], op[2]);
            } else if (op[0] == 2) {
                int value = lruCache.get(op[1]);
                values.add(value);
            }
        }
        int[] ans = new int[values.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = values.get(i);
        }
        return ans;
    }
}
