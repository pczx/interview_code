package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, ans, new ArrayList<Integer>());
        return ans;
    }

    public void dfs(int[] nums, int index, List<List<Integer>> ans, List<Integer> cnt) {
        ans.add(new ArrayList<>(cnt));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            cnt.add(nums[i]);
            dfs(nums, index + 1, ans, cnt);
            cnt.remove(cnt.size() - 1);
        }
    }
}
