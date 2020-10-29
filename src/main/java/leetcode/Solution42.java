package leetcode;

class Solution42 {
    public int maxSubArray(int[] nums) {
        int nCurSum = 0;
        int nGreatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nCurSum <= 0) {
                nCurSum = nums[i];
            } else {
                nCurSum += nums[i];
            }

            if (nCurSum > nGreatestSum) {
                nGreatestSum = nCurSum;
            }
        }
        return nGreatestSum;
    }
}