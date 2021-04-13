package leetcode;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    int ptr;
    int n;
    String[] record;

    public OrderedStream(int n) {
        this.ptr = 1;
        this.n = n + 1;
        record = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<>();
        record[idKey] = value;
        if (record[ptr] == null) {
            return ans;
        } else {
            int i = ptr;
            while (i < n && record[i] != null) {
                ans.add(record[i]);
                i++;
            }
            ptr = i;
        }
        return ans;
    }
}
