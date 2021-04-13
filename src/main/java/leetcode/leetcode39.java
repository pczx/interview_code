package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();
        dfs(candidates, target, ans, cnt, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> cnt, int index) {
        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(cnt));
            return;
        }

        dfs(candidates, target, ans, cnt, index + 1);

        if (target - candidates[index] >= 0) {
            cnt.add(candidates[index]);
            dfs(candidates, target - candidates[index], ans, cnt, index);
            cnt.remove(cnt.size() - 1);
        }
    }
}
