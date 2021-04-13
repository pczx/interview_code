package leetcode;

import java.util.Arrays;

public class leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < Math.abs(ans - target)) {
                        ans = sum;
                    }
                }
            }
        }
        return (int)ans;
    }
}
