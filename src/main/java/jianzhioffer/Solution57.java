package jianzhioffer;

public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                ans[0] = nums[i];
                ans[1] = nums[j];
                return ans;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
