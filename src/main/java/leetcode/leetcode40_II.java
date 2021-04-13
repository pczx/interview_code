package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode40_II {

    List<List<Integer>> ans = new ArrayList<>();

    List<Integer> cnt = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target);
        return ans;
    }

    public void dfs(int[] candidates, int index, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(cnt));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            int curSum = sum + candidates[i];
            if (curSum > target) break;
            cnt.add(candidates[i]);
            dfs(candidates, i + 1, sum + candidates[i], target);
            cnt.remove(cnt.size() - 1);
        }
    }
}
