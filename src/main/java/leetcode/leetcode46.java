package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class leetcode46 {
    List<Integer> nums;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(0);
        return ans;
    }

    public void dfs(int index) {
        if (index == nums.size()) {
            ans.add(new ArrayList<>(nums));
        }
        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, i, index);
            dfs(index + 1);
            Collections.swap(nums, index, i);
        }
    }
}
