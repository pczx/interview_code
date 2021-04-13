package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        ans.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = ans.get(i - 1);
            row.add(1);
            for (int j = 0; j + 1 < i; j++) {
                row.add(preRow.get(j) + preRow.get(j + 1));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }
}
