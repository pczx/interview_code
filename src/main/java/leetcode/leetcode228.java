package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            j = i;
            while (j + 1 < nums.length && nums[j + 1] - nums[j] == 1) {
                j++;
            }
            if (i == j) {
                ans.add(String.valueOf(nums[i]));
            } else {
                ans.add(nums[i] + "->" + nums[j]);
            }
            i = j;
        }
        return ans;
    }
}
