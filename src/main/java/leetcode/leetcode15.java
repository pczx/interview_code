package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return ans;
    }
}
